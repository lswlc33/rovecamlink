# XTU GO — 类与成员明细：com.gku.loginmodule.viewmodels

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 50 个文件 / 71 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.viewmodels.AnnouncementLatestViewModel`
L11 · [class] public AnnouncementLatestViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/AnnouncementLatestViewModel.java`

字段/常量（4）：
- `String TAG = "AnnouncementLatestVM"`  L12
- `MutableLiveData<Announcement> announcement`  L13
- `MutableLiveData<List<Announcement>> announcementList`  L14
- `AnnouncementRepository mRepository`  L15

方法（6）：
- `public AnnouncementLatestViewModel()`  L17
- `public AnnouncementLatestViewModel(AnnouncementRepository repository, GetLanguageListRepository languageListRepository)`  L23 @Inject
- `void getAnnouncementList()`  L28
- `void getAnnouncementByTitle(String title)`  L33
- `void deleteAllAnnouncement()`  L38
- `void deleteAnnouncementByTitle(String title)`  L43
### `com.gku.loginmodule.viewmodels.AnnouncementLatestViewModel_Factory`
L9 · [class] public final AnnouncementLatestViewModel_Factory · implements `Factory<AnnouncementLatestViewModel>` · `com/gku/loginmodule/viewmodels/AnnouncementLatestViewModel_Factory.java`

字段/常量（2）：
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L10
- `Provider<AnnouncementRepository> repositoryProvider`  L11

方法（4）：
- `public AnnouncementLatestViewModel_Factory(Provider<AnnouncementRepository> repositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L13
- `AnnouncementLatestViewModel get()`  L19 @Override
- `AnnouncementLatestViewModel_Factory create(Provider<AnnouncementRepository> repositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L23
- `AnnouncementLatestViewModel newInstance(AnnouncementRepository repository, GetLanguageListRepository languageListRepository)`  L27
### `com.gku.loginmodule.viewmodels.BaseViewModel`
L14 · [class] public BaseViewModel · extends `ViewModel` · `com/gku/loginmodule/viewmodels/BaseViewModel.java`

字段/常量（12）：
- `int ERR_ACCOUNT_NOT_EXIST = 10015`  L15
- `int ERR_ACCOUNT_OR_PASSWORD = 10012`  L16
- `int ERR_EMAIL = 10010`  L17
- `int ERR_EMAIL_REGISTERD = 10014`  L18
- `int ERR_INVALID_TOKEN = 10016`  L19
- `int ERR_OLD_PASSWORD = 10022`  L20
- `int ERR_VCODE_PREQUENT = 10017`  L21
- `int ERR_VCOED = 10011`  L22
- `int ERR_VODE_EXPIRED = 10018`  L23
- `MutableLiveData<String> failed`  L24
- `GetLanguageListRepository languageListRepository`  L25
- `MutableLiveData<List<CloudLanguages>> localLanguagesFromCloud`  L26

方法（3）：
- `public BaseViewModel(GetLanguageListRepository languageListRepository)`  L29 @Inject
- `void getLanguages()`  L33
- `void showCommonErrToast(int code, String msg)`  L37
### `com.gku.loginmodule.viewmodels.BaseViewModel_Factory`
L8 · [class] public final BaseViewModel_Factory · implements `Factory<BaseViewModel>` · `com/gku/loginmodule/viewmodels/BaseViewModel_Factory.java`

字段/常量（1）：
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L9

方法（4）：
- `public BaseViewModel_Factory(Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L11
- `BaseViewModel get()`  L16 @Override
- `BaseViewModel_Factory create(Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L20
- `BaseViewModel newInstance(GetLanguageListRepository languageListRepository)`  L24
### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel`
L22 · [class] public DeleteAccountViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/DeleteAccountViewModel.java`

字段/常量（8）：
- `String TAG = "DeleteAccountViewModel"`  L23
- `DeleteAccountRepository deleteAccountRepository`  L24
- `SingleLiveEvent<DeleteUserResponse> deleteUserResponse`  L25
- `GKUUserRepository gkuUserRepository`  L26
- `MutableLiveData<GKUUser> localGKUUser`  L27
- `SingleLiveEvent<VerifyCodeResponse> sendCode`  L28
- `VerifyCodeRepository verifyCodeRepository`  L29
- `SingleLiveEvent<VerifyCodeResponse> verifyCodeResponse`  L30

方法（11）：
- `public DeleteAccountViewModel(GKUUserRepository gkuUserRepository, VerifyCodeRepository verifyCodeRepository, DeleteAccountRepository deleteAccountRepository, GetLanguageListRepository languageListRepository)`  L33 @Inject
- `void getLocalGKUUser()`  L41
- `void getDeleteAccountVerifyCode(final Activity mActivity, LifecycleOwner lifecycleOwner, String emailAddress)`  L49
- `void onChanged(Object obj)`  L55 @Override
- `void lambda$getDeleteAccountVerifyCode$1(final Activity activity, VerifyCodeResponse verifyCodeResponse)`  L62
    - 体内字面量："getDeleteAccountVerifyCode: è·åéªè¯ç æå"
- `void run()`  L67 @Override
- `void deleteAccount(final UserInfoActivity mActivity, String email, String verifyCode, String pwd)`  L77
- `void onChanged(Object obj)`  L82 @Override
- `void lambda$deleteAccount$3(final UserInfoActivity userInfoActivity, final DeleteUserResponse deleteUserResponse)`  L89
    - 体内字面量："deleteAccount: äºç«¯å é¤è´¦å·æå"
- `void run()`  L96 @Override
- `void lambda$deleteAccount$2(DeleteUserResponse deleteUserResponse, UserInfoActivity userInfoActivity)`  L104
### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel_Factory`
L11 · [class] public final DeleteAccountViewModel_Factory · implements `Factory<DeleteAccountViewModel>` · `com/gku/loginmodule/viewmodels/DeleteAccountViewModel_Factory.java`

字段/常量（4）：
- `Provider<DeleteAccountRepository> deleteAccountRepositoryProvider`  L12
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L13
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L14
- `Provider<VerifyCodeRepository> verifyCodeRepositoryProvider`  L15

方法（4）：
- `public DeleteAccountViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<VerifyCodeRepository> verifyCodeRepositoryProvider, Provider<DeleteAccountRepository> deleteAccountRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L17
- `DeleteAccountViewModel get()`  L25 @Override
- `DeleteAccountViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<VerifyCodeRepository> verifyCodeRepositoryProvider, Provider<DeleteAccountRepository> deleteAccountRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L29
- `DeleteAccountViewModel newInstance(GKUUserRepository gkuUserRepository, VerifyCodeRepository verifyCodeRepository, DeleteAccountRepository deleteAccountRepository, GetLanguageListRepository languageListRepository)`  L33
### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel_HiltModules`
L12 · [class] public final DeleteAccountViewModel_HiltModules · `com/gku/loginmodule/viewmodels/DeleteAccountViewModel_HiltModules.java`

方法（1）：
- `private DeleteAccountViewModel_HiltModules()`  L13
### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel_HiltModules_KeyModule_ProvideFactory`
L7 · [class] public final DeleteAccountViewModel_HiltModules_KeyModule_ProvideFactory · implements `Factory<String>` · `com/gku/loginmodule/viewmodels/DeleteAccountViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（3）：
- `String get()`  L9 @Override
- `DeleteAccountViewModel_HiltModules_KeyModule_ProvideFactory create()`  L13
- `String provide()`  L17
### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder`
L21 · [class] private static final InstanceHolder · `com/gku/loginmodule/viewmodels/DeleteAccountViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（1）：
- `private InstanceHolder()`  L24
### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel_HiltModules$BindsModule`
L17 · [class] public static abstract BindsModule · `com/gku/loginmodule/viewmodels/DeleteAccountViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `ViewModel binds(DeleteAccountViewModel vm)`  L21 @Binds @IntoMap @StringKey("com.gku.loginmodule.viewmodels.DeleteAccountViewModel")
- `private BindsModule()`  L23
### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel_HiltModules$KeyModule`
L28 · [class] public static final KeyModule · `com/gku/loginmodule/viewmodels/DeleteAccountViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `private KeyModule()`  L29
- `String provide()`  L34 @Provides @IntoSet
    - 体内字面量："com.gku.loginmodule.viewmodels.DeleteAccountViewModel"
### `com.gku.loginmodule.viewmodels.DeviceInfoViewModel`
L11 · [class] public DeviceInfoViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/DeviceInfoViewModel.java`

字段/常量（3）：
- `MutableLiveData<List<DeviceVersionInfo>> deviceList`  L12
- `MutableLiveData<GetDeviceNewestVersionResponse.DataBean> deviceNewestLivedata`  L13
- `DeviceInfoRepository mRepository`  L14

方法（4）：
- `public DeviceInfoViewModel()`  L16
- `void getDeviceList()`  L22
- `void deleteDevice(DeviceVersionInfo deviceInfo)`  L27
- `void deleteDeviceList(List<DeviceVersionInfo> deviceInfos)`  L32
### `com.gku.loginmodule.viewmodels.DeviceUpgradeViewModel`
L10 · [class] public DeviceUpgradeViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/DeviceUpgradeViewModel.java`

字段/常量（2）：
- `MutableLiveData<GetDeviceNewestVersionResponse.DataBean> deviceNewestLivedata`  L11
- `DeviceInfoRepository mRepository`  L12

方法（2）：
- `public DeviceUpgradeViewModel()`  L14
- `void updateDevice(DeviceVersionInfo deviceInfo)`  L20
### `com.gku.loginmodule.viewmodels.ForgetPasswordFragmentViewModel`
L20 · [class] public ForgetPasswordFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/ForgetPasswordFragmentViewModel.java`

字段/常量（6）：
- `String TAG = "ForgetPwdFragmentVM"`  L21
- `ForgetPasswordRepository forgetPwdRepository`  L22
- `SingleLiveEvent<ForgetPwdResponse> forgetPwdResponse`  L23
- `MutableLiveData<VerifyCodeResponse> sendCode`  L24
- `VerifyCodeRepository verifyCodeRepository`  L25
- `LiveData<VerifyCodeResponse> verifyCodeResponse`  L26

方法（8）：
- `public ForgetPasswordFragmentViewModel()`  L28
- `void getForgetPwdVerifyCode(final Login_Register_Activity mActivity, LifecycleOwner lifecycleOwner, String emailAddress)`  L43
- `void onChanged(Object obj)`  L49 @Override
- `void lambda$getForgetPwdVerifyCode$1(final Login_Register_Activity login_Register_Activity, VerifyCodeResponse verifyCodeResponse)`  L56
    - 体内字面量："getForgetPwdVerifyCode: è·åéªè¯ç æå"
- `void run()`  L61 @Override
- `void forgetPassword(final Login_Register_Activity mActivity, LifecycleOwner lifecycleOwner, String emailAddress, String password, String verifyCode)`  L71
- `void onChanged(Object obj)`  L76 @Override
- `void lambda$forgetPassword$2(Login_Register_Activity login_Register_Activity, ForgetPwdResponse forgetPwdResponse)`  L83
    - 体内字面量："forgetPassword: è·åå¿è®°å¯ç ååºæå"
### `com.gku.loginmodule.viewmodels.ForgetPasswordFragmentViewModel_Factory`
L10 · [class] public final ForgetPasswordFragmentViewModel_Factory · implements `Factory<ForgetPasswordFragmentViewModel>` · `com/gku/loginmodule/viewmodels/ForgetPasswordFragmentViewModel_Factory.java`

字段/常量（3）：
- `Provider<ForgetPasswordRepository> forgetPwdRepositoryProvider`  L11
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L12
- `Provider<VerifyCodeRepository> verifyCodeRepositoryProvider`  L13

方法（4）：
- `public ForgetPasswordFragmentViewModel_Factory(Provider<VerifyCodeRepository> verifyCodeRepositoryProvider, Provider<ForgetPasswordRepository> forgetPwdRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L15
- `ForgetPasswordFragmentViewModel get()`  L22 @Override
- `ForgetPasswordFragmentViewModel_Factory create(Provider<VerifyCodeRepository> verifyCodeRepositoryProvider, Provider<ForgetPasswordRepository> forgetPwdRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L26
- `ForgetPasswordFragmentViewModel newInstance(VerifyCodeRepository verifyCodeRepository, ForgetPasswordRepository forgetPwdRepository, GetLanguageListRepository languageListRepository)`  L30
### `com.gku.loginmodule.viewmodels.HomeActivityViewModel`
L28 · [class] public HomeActivityViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/HomeActivityViewModel.java`

字段/常量（9）：
- `String TAG = "HomeActivityViewModel"`  L29
- `MutableLiveData<List<Announcement>> announcementList`  L30
- `AnnouncementRepository announcementRepository`  L31
- `DeviceInfoRepository deviceInfoRepository`  L32
- `GetPromotionListRepository getPromotionListRepository`  L33
- `LiveData<GetPromotionListResponse> getPromotionListResponse`  L34
- `boolean isGetPromotionSuccessfully`  L35
- `MVUtils mvUtils`  L36
- `boolean z = false`  L83

方法（9）：
- `public HomeActivityViewModel()`  L38
- `public HomeActivityViewModel(GetLanguageListRepository languageListRepository, GetPromotionListRepository getPromotionListRepository, AnnouncementRepository announcementRepository, DeviceInfoRepository deviceInfoRepository)`  L49 @Inject
- `void getPromotionList(final HomeActivity mActivity, String language)`  L59
- `void onChanged(Object obj)`  L64 @Override
- `void lambda$getPromotionList$1(final HomeActivity homeActivity, GetPromotionListResponse getPromotionListResponse)`  L72
    - 体内字面量："getPromotionList: è·åä¿éåè¡¨æå"
- `void run()`  L98 @Override
    - 体内字面量："getPromotionList: è·åä¿éåè¡¨å¤±è´¥"
- `void lambda$getPromotionList$0(HomeActivity homeActivity)`  L110
    - 体内字面量："è·åä¿éåè¡¨æå"
- `void getAnnouncementList()`  L115
- `void insertDeviceInfo(DeviceVersionInfo bean)`  L120
### `com.gku.loginmodule.viewmodels.HomeActivityViewModel_Factory`
L11 · [class] public final HomeActivityViewModel_Factory · implements `Factory<HomeActivityViewModel>` · `com/gku/loginmodule/viewmodels/HomeActivityViewModel_Factory.java`

字段/常量（4）：
- `Provider<AnnouncementRepository> announcementRepositoryProvider`  L12
- `Provider<DeviceInfoRepository> deviceInfoRepositoryProvider`  L13
- `Provider<GetPromotionListRepository> getPromotionListRepositoryProvider`  L14
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L15

方法（4）：
- `public HomeActivityViewModel_Factory(Provider<GetLanguageListRepository> languageListRepositoryProvider, Provider<GetPromotionListRepository> getPromotionListRepositoryProvider, Provider<AnnouncementRepository> announcementRepositoryProvider, Provider<DeviceInfoRepository> deviceInfoRepositoryProvider)`  L17
- `HomeActivityViewModel get()`  L25 @Override
- `HomeActivityViewModel_Factory create(Provider<GetLanguageListRepository> languageListRepositoryProvider, Provider<GetPromotionListRepository> getPromotionListRepositoryProvider, Provider<AnnouncementRepository> announcementRepositoryProvider, Provider<DeviceInfoRepository> deviceInfoRepositoryProvider)`  L29
- `HomeActivityViewModel newInstance(GetLanguageListRepository languageListRepository, GetPromotionListRepository getPromotionListRepository, AnnouncementRepository announcementRepository, DeviceInfoRepository deviceInfoRepository)`  L33
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel`
L28 · [class] public LoginFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel.java`

字段/常量（8）：
- `String TAG = "LoginFragmentViewModel"`  L29
- `MutableLiveData<GKUUser> gkuUser`  L30
- `GKUUserRepository gkuUserRepository`  L31
- `LoginRepository loginRepository`  L32
- `SingleLiveEvent<LoginResponse> loginResponse`  L33
- `MVUtils mvUtils`  L34
- `Login_Register_Activity login_Register_Activity2 = login_Register_Activity`  L69
- `Login_Register_Activity login_Register_Activity2 = login_Register_Activity`  L100

方法（9）：
- `MutableLiveData<GKUUser> getGKUUser()`  L44
- `void login(final Login_Register_Activity mActivity, final String emailAddress, final String password, final String language, final String productModel, final String habits, final CallBack callBack)`  L51
- `void onChanged(Object obj)`  L56 @Override
- `void lambda$login$3(final Login_Register_Activity login_Register_Activity, String str, String str2, String str3, String str4, String str5, CallBack callBack, final LoginResponse loginResponse)`  L63
- `void run()`  L68 @Override
- `void run()`  L99 @Override
- `void run()`  L107 @Override
- `void lambda$login$2(LoginResponse loginResponse, Login_Register_Activity login_Register_Activity)`  L117
- `void saveGKUserToRoom(Login_Register_Activity mActivity)`  L121
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel_Factory`
L10 · [class] public final LoginFragmentViewModel_Factory · implements `Factory<LoginFragmentViewModel>` · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel_Factory.java`

字段/常量（3）：
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L11
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L12
- `Provider<LoginRepository> loginRepositoryProvider`  L13

方法（4）：
- `public LoginFragmentViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<LoginRepository> loginRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L15
- `LoginFragmentViewModel get()`  L22 @Override
- `LoginFragmentViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<LoginRepository> loginRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L26
- `LoginFragmentViewModel newInstance(GKUUserRepository gkuUserRepository, LoginRepository loginRepository, GetLanguageListRepository languageListRepository)`  L30
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel_HiltModules`
L12 · [class] public final LoginFragmentViewModel_HiltModules · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel_HiltModules.java`

方法（1）：
- `private LoginFragmentViewModel_HiltModules()`  L13
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel_HiltModules_KeyModule_ProvideFactory`
L7 · [class] public final LoginFragmentViewModel_HiltModules_KeyModule_ProvideFactory · implements `Factory<String>` · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（3）：
- `String get()`  L9 @Override
- `LoginFragmentViewModel_HiltModules_KeyModule_ProvideFactory create()`  L13
- `String provide()`  L17
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder`
L21 · [class] private static final InstanceHolder · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（1）：
- `private InstanceHolder()`  L24
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel_HiltModules$BindsModule`
L17 · [class] public static abstract BindsModule · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `ViewModel binds(LoginFragmentViewModel vm)`  L21 @Binds @IntoMap @StringKey("com.gku.loginmodule.viewmodels.LoginFragmentViewModel")
- `private BindsModule()`  L23
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel_HiltModules$KeyModule`
L28 · [class] public static final KeyModule · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `private KeyModule()`  L29
- `String provide()`  L34 @Provides @IntoSet
    - 体内字面量："com.gku.loginmodule.viewmodels.LoginFragmentViewModel"
### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel$$ExternalSyntheticLambda4`
L7 · [class] public final LoginFragmentViewModel$$ExternalSyntheticLambda4 · implements `Runnable` · `com/gku/loginmodule/viewmodels/LoginFragmentViewModel$$ExternalSyntheticLambda4.java`

字段/常量（1）：
- `CallBack f$0`  L8

方法（1）：
- `void run()`  L11 @Override
### `com.gku.loginmodule.viewmodels.LoginRegisterViewModel`
L17 · [class] public LoginRegisterViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/LoginRegisterViewModel.java`

字段/常量（4）：
- `GetLanguageListRepository getLanguageListRepository`  L18
- `LiveData<GetLanguagesResponse> getLanguagesResponse`  L19
- `LiveData<GKUUser> gkuUser`  L20
- `GKUUserRepository gkuUserRepository`  L21

方法（4）：
- `LiveData<GKUUser> getGKUUser()`  L30
- `void getLanguageListRequest(final Login_Register_Activity mActivity, LifecycleOwner lifecycleOwner)`  L39
- `void onChanged(Object obj)`  L44 @Override
- `void lambda$getLanguageListRequest$0(Login_Register_Activity login_Register_Activity, GetLanguagesResponse getLanguagesResponse)`  L50
### `com.gku.loginmodule.viewmodels.LoginRegisterViewModel_Factory`
L9 · [class] public final LoginRegisterViewModel_Factory · implements `Factory<LoginRegisterViewModel>` · `com/gku/loginmodule/viewmodels/LoginRegisterViewModel_Factory.java`

字段/常量（3）：
- `Provider<GetLanguageListRepository> getLanguageListRepositoryProvider`  L10
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L11
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L12

方法（4）：
- `public LoginRegisterViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> getLanguageListRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L14
- `LoginRegisterViewModel get()`  L21 @Override
- `LoginRegisterViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> getLanguageListRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L25
- `LoginRegisterViewModel newInstance(GKUUserRepository gkuUserRepository, GetLanguageListRepository getLanguageListRepository, GetLanguageListRepository languageListRepository)`  L29
### `com.gku.loginmodule.viewmodels.LoginRegisterViewModel_HiltModules`
L12 · [class] public final LoginRegisterViewModel_HiltModules · `com/gku/loginmodule/viewmodels/LoginRegisterViewModel_HiltModules.java`

方法（1）：
- `private LoginRegisterViewModel_HiltModules()`  L13
### `com.gku.loginmodule.viewmodels.LoginRegisterViewModel_HiltModules_KeyModule_ProvideFactory`
L7 · [class] public final LoginRegisterViewModel_HiltModules_KeyModule_ProvideFactory · implements `Factory<String>` · `com/gku/loginmodule/viewmodels/LoginRegisterViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（3）：
- `String get()`  L9 @Override
- `LoginRegisterViewModel_HiltModules_KeyModule_ProvideFactory create()`  L13
- `String provide()`  L17
### `com.gku.loginmodule.viewmodels.LoginRegisterViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder`
L21 · [class] private static final InstanceHolder · `com/gku/loginmodule/viewmodels/LoginRegisterViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（1）：
- `private InstanceHolder()`  L24
### `com.gku.loginmodule.viewmodels.LoginRegisterViewModel_HiltModules$BindsModule`
L17 · [class] public static abstract BindsModule · `com/gku/loginmodule/viewmodels/LoginRegisterViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `ViewModel binds(LoginRegisterViewModel vm)`  L21 @Binds @IntoMap @StringKey("com.gku.loginmodule.viewmodels.LoginRegisterViewModel")
- `private BindsModule()`  L23
### `com.gku.loginmodule.viewmodels.LoginRegisterViewModel_HiltModules$KeyModule`
L28 · [class] public static final KeyModule · `com/gku/loginmodule/viewmodels/LoginRegisterViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `private KeyModule()`  L29
- `String provide()`  L34 @Provides @IntoSet
    - 体内字面量："com.gku.loginmodule.viewmodels.LoginRegisterViewModel"
### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel`
L18 · [class] public ModifyPasswordFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/ModifyPasswordFragmentViewModel.java`

字段/常量（5）：
- `String TAG = "ModifyPwdFV"`  L19
- `GKUUserRepository gkuUserRepository`  L20
- `MutableLiveData<GKUUser> localGkuUser`  L21
- `ModifyPasswordRepository modifyPwdRepository`  L22
- `SingleLiveEvent<ModifyPwdResponse> modifyPwdResponse`  L23

方法（7）：
- `void getLocalGKUUser()`  L32
- `void modifyPassword(final UserInfoActivity mActivity, LifecycleOwner lifecycleOwner, String id, String oldPwd, String newPwd)`  L40
- `void onChanged(Object obj)`  L45 @Override
- `void lambda$modifyPassword$2(final UserInfoActivity userInfoActivity, final ModifyPwdResponse modifyPwdResponse)`  L52
    - 体内字面量："modifyPassword: ä¿®æ¹å¯ç æå"
- `void run()`  L57 @Override
    - 体内字面量："modifyPassword: ä¿®æ¹å¯ç å¤±è´¥"
- `void run()`  L66 @Override
- `void lambda$modifyPassword$1(ModifyPwdResponse modifyPwdResponse, UserInfoActivity userInfoActivity)`  L74
### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel_Factory`
L10 · [class] public final ModifyPasswordFragmentViewModel_Factory · implements `Factory<ModifyPasswordFragmentViewModel>` · `com/gku/loginmodule/viewmodels/ModifyPasswordFragmentViewModel_Factory.java`

字段/常量（3）：
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L11
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L12
- `Provider<ModifyPasswordRepository> modifyPwdRepositoryProvider`  L13

方法（4）：
- `public ModifyPasswordFragmentViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<ModifyPasswordRepository> modifyPwdRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L15
- `ModifyPasswordFragmentViewModel get()`  L22 @Override
- `ModifyPasswordFragmentViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<ModifyPasswordRepository> modifyPwdRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L26
- `ModifyPasswordFragmentViewModel newInstance(GKUUserRepository gkuUserRepository, ModifyPasswordRepository modifyPwdRepository, GetLanguageListRepository languageListRepository)`  L30
### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel_HiltModules`
L12 · [class] public final ModifyPasswordFragmentViewModel_HiltModules · `com/gku/loginmodule/viewmodels/ModifyPasswordFragmentViewModel_HiltModules.java`

方法（1）：
- `private ModifyPasswordFragmentViewModel_HiltModules()`  L13
### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel_HiltModules_KeyModule_ProvideFactory`
L7 · [class] public final ModifyPasswordFragmentViewModel_HiltModules_KeyModule_ProvideFactory · implements `Factory<String>` · `com/gku/loginmodule/viewmodels/ModifyPasswordFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（3）：
- `String get()`  L9 @Override
- `ModifyPasswordFragmentViewModel_HiltModules_KeyModule_ProvideFactory create()`  L13
- `String provide()`  L17
### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder`
L21 · [class] private static final InstanceHolder · `com/gku/loginmodule/viewmodels/ModifyPasswordFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（1）：
- `private InstanceHolder()`  L24
### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel_HiltModules$BindsModule`
L17 · [class] public static abstract BindsModule · `com/gku/loginmodule/viewmodels/ModifyPasswordFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `ViewModel binds(ModifyPasswordFragmentViewModel vm)`  L21 @Binds @IntoMap @StringKey("com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel")
- `private BindsModule()`  L23
### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel_HiltModules$KeyModule`
L28 · [class] public static final KeyModule · `com/gku/loginmodule/viewmodels/ModifyPasswordFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `private KeyModule()`  L29
- `String provide()`  L34 @Provides @IntoSet
    - 体内字面量："com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel"
### `com.gku.loginmodule.viewmodels.OperationFailFragmentViewModel`
L7 · [class] public OperationFailFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/OperationFailFragmentViewModel.java`

方法（2）：
- `public OperationFailFragmentViewModel()`  L8
- `public OperationFailFragmentViewModel(GetLanguageListRepository languageListRepository)`  L13 @Inject
### `com.gku.loginmodule.viewmodels.OperationFailFragmentViewModel_Factory`
L8 · [class] public final OperationFailFragmentViewModel_Factory · implements `Factory<OperationFailFragmentViewModel>` · `com/gku/loginmodule/viewmodels/OperationFailFragmentViewModel_Factory.java`

字段/常量（1）：
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L9

方法（4）：
- `public OperationFailFragmentViewModel_Factory(Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L11
- `OperationFailFragmentViewModel get()`  L16 @Override
- `OperationFailFragmentViewModel_Factory create(Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L20
- `OperationFailFragmentViewModel newInstance(GetLanguageListRepository languageListRepository)`  L24
### `com.gku.loginmodule.viewmodels.OperationSuccessFragmentViewModel`
L7 · [class] public OperationSuccessFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/OperationSuccessFragmentViewModel.java`

方法（2）：
- `public OperationSuccessFragmentViewModel()`  L8
- `public OperationSuccessFragmentViewModel(GetLanguageListRepository languageListRepository)`  L13 @Inject
### `com.gku.loginmodule.viewmodels.OperationSuccessFragmentViewModel_Factory`
L8 · [class] public final OperationSuccessFragmentViewModel_Factory · implements `Factory<OperationSuccessFragmentViewModel>` · `com/gku/loginmodule/viewmodels/OperationSuccessFragmentViewModel_Factory.java`

字段/常量（1）：
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L9

方法（4）：
- `public OperationSuccessFragmentViewModel_Factory(Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L11
- `OperationSuccessFragmentViewModel get()`  L16 @Override
- `OperationSuccessFragmentViewModel_Factory create(Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L20
- `OperationSuccessFragmentViewModel newInstance(GetLanguageListRepository languageListRepository)`  L24
### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel`
L19 · [class] public PhoneNumberFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/PhoneNumberFragmentViewModel.java`

字段/常量（8）：
- `String TAG = "PhoneNumberFmViewModel"`  L20
- `GKUUserRepository gkuUserRepository`  L21
- `boolean isToastShown`  L22
- `MutableLiveData<GKUUser> localGKUUser`  L23
- `UpdateUserInfoRepository updateUserInfoRepository`  L24
- `MutableLiveData<UpdateUserInformationResponse> updateUserInformationResponse`  L25
- `Activity activity2 = activity`  L63
- `Activity activity2 = activity`  L71

方法（7）：
- `public PhoneNumberFragmentViewModel(GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository, UpdateUserInfoRepository updateUserInfoRepository)`  L28 @Inject
- `void getGkuUser()`  L35
- `void syncPhoneNumToRoomAndCloud(final Activity mActivity, LifecycleOwner lifecycleOwner, String phoneNum)`  L39
    - 体内字面量："Update the GKUser in the Room: "
- `void onChanged(Object obj)`  L47 @Override
- `void lambda$syncPhoneNumToRoomAndCloud$2(final Activity activity, UpdateUserInformationResponse updateUserInformationResponse)`  L54
- `void run()`  L62 @Override
- `void run()`  L70 @Override
### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel_Factory`
L10 · [class] public final PhoneNumberFragmentViewModel_Factory · implements `Factory<PhoneNumberFragmentViewModel>` · `com/gku/loginmodule/viewmodels/PhoneNumberFragmentViewModel_Factory.java`

字段/常量（3）：
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L11
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L12
- `Provider<UpdateUserInfoRepository> updateUserInfoRepositoryProvider`  L13

方法（4）：
- `public PhoneNumberFragmentViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider, Provider<UpdateUserInfoRepository> updateUserInfoRepositoryProvider)`  L15
- `PhoneNumberFragmentViewModel get()`  L22 @Override
- `PhoneNumberFragmentViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider, Provider<UpdateUserInfoRepository> updateUserInfoRepositoryProvider)`  L26
- `PhoneNumberFragmentViewModel newInstance(GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository, UpdateUserInfoRepository updateUserInfoRepository)`  L30
### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel_HiltModules`
L12 · [class] public final PhoneNumberFragmentViewModel_HiltModules · `com/gku/loginmodule/viewmodels/PhoneNumberFragmentViewModel_HiltModules.java`

方法（1）：
- `private PhoneNumberFragmentViewModel_HiltModules()`  L13
### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel_HiltModules_KeyModule_ProvideFactory`
L7 · [class] public final PhoneNumberFragmentViewModel_HiltModules_KeyModule_ProvideFactory · implements `Factory<String>` · `com/gku/loginmodule/viewmodels/PhoneNumberFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（3）：
- `String get()`  L9 @Override
- `PhoneNumberFragmentViewModel_HiltModules_KeyModule_ProvideFactory create()`  L13
- `String provide()`  L17
### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder`
L21 · [class] private static final InstanceHolder · `com/gku/loginmodule/viewmodels/PhoneNumberFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（1）：
- `private InstanceHolder()`  L24
### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel_HiltModules$BindsModule`
L17 · [class] public static abstract BindsModule · `com/gku/loginmodule/viewmodels/PhoneNumberFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `ViewModel binds(PhoneNumberFragmentViewModel vm)`  L21 @Binds @IntoMap @StringKey("com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel")
- `private BindsModule()`  L23
### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel_HiltModules$KeyModule`
L28 · [class] public static final KeyModule · `com/gku/loginmodule/viewmodels/PhoneNumberFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `private KeyModule()`  L29
- `String provide()`  L34 @Provides @IntoSet
    - 体内字面量："com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel"
### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel`
L22 · [class] public RegisterFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/RegisterFragmentViewModel.java`

字段/常量（8）：
- `String TAG = "RegisterFragmentVM"`  L23
- `MutableLiveData<GKUUser> gkuUser`  L24
- `GKUUserRepository gkuUserRepository`  L25
- `RegisterRepository registerRepository`  L26
- `LiveData<RegisterResponse> registerResponse`  L27
- `SingleLiveEvent<VerifyCodeResponse> sendCode`  L28
- `VerifyCodeRepository verifyCodeRepository`  L29
- `SingleLiveEvent<VerifyCodeResponse> verifyCodeResponse`  L30

方法（9）：
- `public RegisterFragmentViewModel(GKUUserRepository gkuUserRepository, VerifyCodeRepository verifyCodeRepository, RegisterRepository registerRepository, GetLanguageListRepository languageListRepository)`  L33 @Inject
- `MutableLiveData<GKUUser> getGKUUser()`  L41
- `void getRegisterVerifyCode(final Login_Register_Activity mActivity, LifecycleOwner lifecycleOwner, String emailAddress)`  L50
- `void onChanged(Object obj)`  L56 @Override
- `void lambda$getRegisterVerifyCode$1(final Login_Register_Activity login_Register_Activity, VerifyCodeResponse verifyCodeResponse)`  L63
    - 体内字面量："getRegisterVerifyCode: è·åéªè¯ç æå"
- `void run()`  L68 @Override
- `void register(final Login_Register_Activity mActivity, String emailAddress, String password, String verifyCode, String language)`  L78
- `void onChanged(Object obj)`  L83 @Override
- `void lambda$register$2(Login_Register_Activity login_Register_Activity, RegisterResponse registerResponse)`  L90
### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel_Factory`
L11 · [class] public final RegisterFragmentViewModel_Factory · implements `Factory<RegisterFragmentViewModel>` · `com/gku/loginmodule/viewmodels/RegisterFragmentViewModel_Factory.java`

字段/常量（4）：
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L12
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L13
- `Provider<RegisterRepository> registerRepositoryProvider`  L14
- `Provider<VerifyCodeRepository> verifyCodeRepositoryProvider`  L15

方法（4）：
- `public RegisterFragmentViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<VerifyCodeRepository> verifyCodeRepositoryProvider, Provider<RegisterRepository> registerRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L17
- `RegisterFragmentViewModel get()`  L25 @Override
- `RegisterFragmentViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<VerifyCodeRepository> verifyCodeRepositoryProvider, Provider<RegisterRepository> registerRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L29
- `RegisterFragmentViewModel newInstance(GKUUserRepository gkuUserRepository, VerifyCodeRepository verifyCodeRepository, RegisterRepository registerRepository, GetLanguageListRepository languageListRepository)`  L33
### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel_HiltModules`
L12 · [class] public final RegisterFragmentViewModel_HiltModules · `com/gku/loginmodule/viewmodels/RegisterFragmentViewModel_HiltModules.java`

方法（1）：
- `private RegisterFragmentViewModel_HiltModules()`  L13
### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel_HiltModules_KeyModule_ProvideFactory`
L7 · [class] public final RegisterFragmentViewModel_HiltModules_KeyModule_ProvideFactory · implements `Factory<String>` · `com/gku/loginmodule/viewmodels/RegisterFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（3）：
- `String get()`  L9 @Override
- `RegisterFragmentViewModel_HiltModules_KeyModule_ProvideFactory create()`  L13
- `String provide()`  L17
### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder`
L21 · [class] private static final InstanceHolder · `com/gku/loginmodule/viewmodels/RegisterFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（1）：
- `private InstanceHolder()`  L24
### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel_HiltModules$BindsModule`
L17 · [class] public static abstract BindsModule · `com/gku/loginmodule/viewmodels/RegisterFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `ViewModel binds(RegisterFragmentViewModel vm)`  L21 @Binds @IntoMap @StringKey("com.gku.loginmodule.viewmodels.RegisterFragmentViewModel")
- `private BindsModule()`  L23
### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel_HiltModules$KeyModule`
L28 · [class] public static final KeyModule · `com/gku/loginmodule/viewmodels/RegisterFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `private KeyModule()`  L29
- `String provide()`  L34 @Provides @IntoSet
    - 体内字面量："com.gku.loginmodule.viewmodels.RegisterFragmentViewModel"
### `com.gku.loginmodule.viewmodels.ReportFeedbackViewModel`
L33 · [class] public ReportFeedbackViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/ReportFeedbackViewModel.java`

字段/常量（16）：
- `String TAG = "ReportFeedbackViewModel"`  L34
- `MutableLiveData<GKUUser> gkuUser`  L35
- `GKUUserRepository gkuUserRepository`  L36
- `HashMap<String, String> languageChina`  L37
- `HashMap<String, String> languageJapan`  L38
- `SingleLiveEvent<String> mAttachmentUrl`  L39
- `SingleLiveEvent<String> mLogUrl`  L40
- `MutableLiveData<Map<Map<String, String>, List<Map<String, String>>>> mPTAndPMSpinnerMap`  L41
- `MutableLiveData<List<Map<String, String>>> mProblemTypeSpinnerMapList`  L42
- `ProblemTypesRepository problemTypesRepository`  L43
- `LiveData<GetProblemTypesResponse> problemTypesResponse`  L44
- `PTAndPMRepository ptAndPMRepository`  L45
- `LiveData<GetProductTypesResponse> ptAndPMResponse`  L46
- `ReportFeedbackRepository reportFeedbackRepository`  L47
- `LiveData<ReportFeedbackResponse> reportFeedbackResponse`  L48
- `UploadAttachmentRepository uploadAttachmentRepository`  L49

方法（34）：
- `void lambda$getPTAndPM$0()`  L51
- `void lambda$getProblemTypes$3()`  L54
- `public ReportFeedbackViewModel()`  L57
    - 体内字面量："System abnormal" · "ç³»ç»å¡é¡¿" · "VideoNotPlay" · "è§é¢æ æ³æ­æ¾" · "Device file storage" · "è®¾å¤æä»¶å­å¨" · "Device file download" · "è®¾å¤æä»¶ä¸è½½" · "Device Preview & Playback" · "è®¾å¤é¢è§&åæ¾" · "Experience & improvement" · "ä½¿ç¨ä½éªä¸æ¹è¿" · "APP album & share" · "APPç¸å&åäº«" · "APP Compatibility" · "APPå¼å®¹æ§" · "APP experience and improvement" · "APPä½¿ç¨ä½éªä¸æ¹è¿" · "Others" · "å¶ä»" · "System abnormal" · "ã·ã¹ãã ç°å¸¸" · "VideoNotPlay" · "ãããªåçä¸è½" · "Device file storage" · "ããã¤ã¹ãã¡ã¤ã«ã¹ãã¬ã¼ã¸" · "Device file download" · "ããã¤ã¹ãã¡ã¤ã«ãã¦ã³ã­ã¼ã" · "Device Preview & Playback" · "ããã¤ã¹ãã¬ãã¥ã¼ï¼åç" · "Experience & improvement" · "ä½¿ç¨ä½é¨ï¼æ¹å" · "APP album & share" · "APPã¢ã«ãã ï¼å±æ" · "APP Compatibility" · "APPäºææ§" · "APP experience and improvement" · "APPä½¿ç¨ä½é¨ï¼æ¹å" · "Others" · "ãã®ä»"
- `public ReportFeedbackViewModel(PTAndPMRepository ptAndPMRepository, ProblemTypesRepository problemTypesRepository, UploadAttachmentRepository uploadAttachmentRepository, ReportFeedbackRepository reportFeedbackRepository, GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository)`  L93 @Inject
- `void getPTAndPM(final Report_Feedback_Activity mActivity, LifecycleOwner lifecycleOwner)`  L108
- `void onChanged(Object obj)`  L113 @Override
- `void lambda$getPTAndPM$2(final Report_Feedback_Activity report_Feedback_Activity, GetProductTypesResponse getProductTypesResponse)`  L120
- `void run()`  L144 @Override
- `void run()`  L152 @Override
    - 体内字面量："è·åäº§åç±»ååäº§ååå·å¤±è´¥"
- `void getProblemTypes(final Report_Feedback_Activity mActivity, LifecycleOwner lifecycleOwner, String language)`  L158
    - 体内字面量："-"
- `void onChanged(Object obj)`  L163 @Override
- `void lambda$getProblemTypes$5(final Report_Feedback_Activity report_Feedback_Activity, GetProblemTypesResponse getProblemTypesResponse)`  L170
- `void run()`  L182 @Override
- `void run()`  L190 @Override
    - 体内字面量："è·åé®é¢ç±»åå¤±è´¥"
- `LiveData<Map<Map<String, String>, List<Map<String, String>>>> getPTAndPMSpinnerMap()`  L196
- `LiveData<List<Map<String, String>>> getProblemTypeSpinnerList()`  L200
- `void uploadAttachment(final Report_Feedback_Activity mActivity, LifecycleOwner lifecycleOwner, File uploadZipFile)`  L204
- `void onChanged(Object obj)`  L207 @Override
- `void lambda$uploadAttachment$8(final Report_Feedback_Activity report_Feedback_Activity, final UploadAttachmentResponse uploadAttachmentResponse)`  L214
- `void run()`  L219 @Override
- `void run()`  L227 @Override
- `SingleLiveEvent<String> getAttachmentUrl()`  L234
- `void uploadLog(final Report_Feedback_Activity mActivity, LifecycleOwner lifecycleOwner, File uploadZipFile)`  L238
- `void onChanged(Object obj)`  L241 @Override
- `void lambda$uploadLog$9(Report_Feedback_Activity report_Feedback_Activity, UploadAttachmentResponse uploadAttachmentResponse)`  L248
- `SingleLiveEvent<String> getLogUrll()`  L256
- `void reportFeedback(final Report_Feedback_Activity mActivity, String productType, String product, String problemTypeId, String mAttachmentUrl, String mLogUrl, String problemDesc, String language, final CallBack callBack)`  L260
    - 体内字面量："xs, " · "productType = " · "xs, " · "product = " · "xs, " · "problemTypeId = " · "xs, " · "mAttachmentUrl = " · "xs, " · "mLogUrl = " · "xs, " · "problemDesc = " · "xs, " · "language = "
- `void onChanged(Object obj)`  L272 @Override
- `void lambda$reportFeedback$12(final Report_Feedback_Activity report_Feedback_Activity, CallBack callBack, final ReportFeedbackResponse reportFeedbackResponse)`  L279
- `void run()`  L283 @Override
- `void run()`  L290 @Override
- `void lambda$reportFeedback$10(Report_Feedback_Activity report_Feedback_Activity)`  L299
- `void lambda$reportFeedback$11(ReportFeedbackResponse reportFeedbackResponse, Report_Feedback_Activity report_Feedback_Activity)`  L305
- `LiveData<GKUUser> getGKUUser()`  L309
### `com.gku.loginmodule.viewmodels.ReportFeedbackViewModel_Factory`
L13 · [class] public final ReportFeedbackViewModel_Factory · implements `Factory<ReportFeedbackViewModel>` · `com/gku/loginmodule/viewmodels/ReportFeedbackViewModel_Factory.java`

字段/常量（6）：
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L14
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L15
- `Provider<ProblemTypesRepository> problemTypesRepositoryProvider`  L16
- `Provider<PTAndPMRepository> ptAndPMRepositoryProvider`  L17
- `Provider<ReportFeedbackRepository> reportFeedbackRepositoryProvider`  L18
- `Provider<UploadAttachmentRepository> uploadAttachmentRepositoryProvider`  L19

方法（4）：
- `public ReportFeedbackViewModel_Factory(Provider<PTAndPMRepository> ptAndPMRepositoryProvider, Provider<ProblemTypesRepository> problemTypesRepositoryProvider, Provider<UploadAttachmentRepository> uploadAttachmentRepositoryProvider, Provider<ReportFeedbackRepository> reportFeedbackRepositoryProvider, Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L21
- `ReportFeedbackViewModel get()`  L31 @Override
- `ReportFeedbackViewModel_Factory create(Provider<PTAndPMRepository> ptAndPMRepositoryProvider, Provider<ProblemTypesRepository> problemTypesRepositoryProvider, Provider<UploadAttachmentRepository> uploadAttachmentRepositoryProvider, Provider<ReportFeedbackRepository> reportFeedbackRepositoryProvider, Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L35
- `ReportFeedbackViewModel newInstance(PTAndPMRepository ptAndPMRepository, ProblemTypesRepository problemTypesRepository, UploadAttachmentRepository uploadAttachmentRepository, ReportFeedbackRepository reportFeedbackRepository, GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository)`  L39
### `com.gku.loginmodule.viewmodels.SingleLiveEvent`
L9 · [class] public SingleLiveEvent · extends `MutableLiveData<T>` · `com/gku/loginmodule/viewmodels/SingleLiveEvent.java`

字段/常量（2）：
- `String TAG = "SingleLiveEvent"`  L10
- `AtomicBoolean mPending`  L11

方法（14）：
- `public SingleLiveEvent()`  L13
- `public SingleLiveEvent(T value)`  L17
- `void observe(LifecycleOwner owner, final Observer<? super T> observer)`  L23 @Override
- `void onChanged(Object obj)`  L26 @Override
- `void lambda$observe$0(Observer observer, Object obj)`  L33
- `void observeForever(final Observer<? super T> observer)`  L40 @Override
- `void onChanged(Object obj)`  L43 @Override
- `void lambda$observeForever$1(Observer observer, Object obj)`  L50
- `void setValue(T value)`  L57 @Override
- `void postValue(T value)`  L63 @Override
- `void notifyObserver()`  L68
- `void reset()`  L76
- `boolean hasPendingEvent()`  L80
- `T getValueAndConsume()`  L84
### `com.gku.loginmodule.viewmodels.UserCenterNewFragmentViewModel`
L25 · [class] public UserCenterNewFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/UserCenterNewFragmentViewModel.java`

字段/常量（10）：
- `String TAG = "UserInfoFmViewModel"`  L26
- `MutableLiveData<Announcement> announcement`  L27
- `MutableLiveData<List<Announcement>> announcementList`  L28
- `AnnouncementRepository announcementRepository`  L29
- `GetPromotionListRepository getPromotionListRepository`  L30
- `LiveData<GetPromotionListResponse> getPromotionListResponse`  L31
- `GKUUserRepository gkuUserRepository`  L32
- `boolean isGetPromotionSuccessfully`  L33
- `MutableLiveData<GKUUser> localGkuUser`  L34
- `boolean z = false`  L83

方法（14）：
- `public UserCenterNewFragmentViewModel()`  L36
- `public UserCenterNewFragmentViewModel(GKUUserRepository gkuUserRepository, GetPromotionListRepository getPromotionListRepository, AnnouncementRepository announcementRepository, GetLanguageListRepository languageListRepository)`  L46 @Inject
- `void getLocalGKUUser()`  L55
- `void getPromotionList(final HomeActivity mActivity, LifecycleOwner lifecycleOwner, String language, final UserCenterNewAdapter adapter)`  L59
- `void onChanged(Object obj)`  L64 @Override
- `void lambda$getPromotionList$1(final HomeActivity homeActivity, final UserCenterNewAdapter userCenterNewAdapter, GetPromotionListResponse getPromotionListResponse)`  L72
    - 体内字面量："getPromotionList: è·åä¿éåè¡¨æå"
- `void run()`  L98 @Override
    - 体内字面量："getPromotionList: è·åä¿éåè¡¨å¤±è´¥"
- `void lambda$getPromotionList$0(UserCenterNewAdapter userCenterNewAdapter, HomeActivity homeActivity)`  L109
    - 体内字面量："è·åä¿éåè¡¨æå"
- `void getAnnouncementList()`  L115
- `boolean getAnnouncementByTitle(String title)`  L120
- `boolean getAnnouncementByContent(String content)`  L126
- `boolean getAnnouncementByLinkUrl(String linkUrl)`  L132
- `boolean getAnnouncementByIconUrl(String iconUrl)`  L138
- `boolean getAnnouncementByCreateTime(String createTime)`  L144
### `com.gku.loginmodule.viewmodels.UserCenterNewFragmentViewModel_Factory`
L11 · [class] public final UserCenterNewFragmentViewModel_Factory · implements `Factory<UserCenterNewFragmentViewModel>` · `com/gku/loginmodule/viewmodels/UserCenterNewFragmentViewModel_Factory.java`

字段/常量（4）：
- `Provider<AnnouncementRepository> announcementRepositoryProvider`  L12
- `Provider<GetPromotionListRepository> getPromotionListRepositoryProvider`  L13
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L14
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L15

方法（4）：
- `public UserCenterNewFragmentViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetPromotionListRepository> getPromotionListRepositoryProvider, Provider<AnnouncementRepository> announcementRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L17
- `UserCenterNewFragmentViewModel get()`  L25 @Override
- `UserCenterNewFragmentViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetPromotionListRepository> getPromotionListRepositoryProvider, Provider<AnnouncementRepository> announcementRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L29
- `UserCenterNewFragmentViewModel newInstance(GKUUserRepository gkuUserRepository, GetPromotionListRepository getPromotionListRepository, AnnouncementRepository announcementRepository, GetLanguageListRepository languageListRepository)`  L33
### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel`
L16 · [class] public UserInfoFragmentViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/UserInfoFragmentViewModel.java`

字段/常量（5）：
- `String TAG = "UserInfoFmViewModel"`  L17
- `GKUUserRepository gkuUserRepository`  L18
- `MutableLiveData<GKUUser> localGkuUser`  L19
- `LogoutRepository logoutRepository`  L20
- `LiveData<LogoutResponse> logoutResponse`  L21

方法（5）：
- `public UserInfoFragmentViewModel(GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository, LogoutRepository logoutRepository)`  L24 @Inject
- `void getLocalGKUUser()`  L31
- `void logout(final UserInfoActivity activity, String email)`  L35
- `void onChanged(Object obj)`  L40 @Override
- `void lambda$logout$0(UserInfoActivity userInfoActivity, LogoutResponse logoutResponse)`  L46
    - 体内字面量："logout: äºç«¯ç»åºè´¦å·æå"
### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel_Factory`
L10 · [class] public final UserInfoFragmentViewModel_Factory · implements `Factory<UserInfoFragmentViewModel>` · `com/gku/loginmodule/viewmodels/UserInfoFragmentViewModel_Factory.java`

字段/常量（3）：
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L11
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L12
- `Provider<LogoutRepository> logoutRepositoryProvider`  L13

方法（4）：
- `public UserInfoFragmentViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider, Provider<LogoutRepository> logoutRepositoryProvider)`  L15
- `UserInfoFragmentViewModel get()`  L22 @Override
- `UserInfoFragmentViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider, Provider<LogoutRepository> logoutRepositoryProvider)`  L26
- `UserInfoFragmentViewModel newInstance(GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository, LogoutRepository logoutRepository)`  L30
### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel_HiltModules`
L12 · [class] public final UserInfoFragmentViewModel_HiltModules · `com/gku/loginmodule/viewmodels/UserInfoFragmentViewModel_HiltModules.java`

方法（1）：
- `private UserInfoFragmentViewModel_HiltModules()`  L13
### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel_HiltModules_KeyModule_ProvideFactory`
L7 · [class] public final UserInfoFragmentViewModel_HiltModules_KeyModule_ProvideFactory · implements `Factory<String>` · `com/gku/loginmodule/viewmodels/UserInfoFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（3）：
- `String get()`  L9 @Override
- `UserInfoFragmentViewModel_HiltModules_KeyModule_ProvideFactory create()`  L13
- `String provide()`  L17
### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder`
L21 · [class] private static final InstanceHolder · `com/gku/loginmodule/viewmodels/UserInfoFragmentViewModel_HiltModules_KeyModule_ProvideFactory.java`

方法（1）：
- `private InstanceHolder()`  L24
### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel_HiltModules$BindsModule`
L17 · [class] public static abstract BindsModule · `com/gku/loginmodule/viewmodels/UserInfoFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `ViewModel binds(UserInfoFragmentViewModel vm)`  L21 @Binds @IntoMap @StringKey("com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel")
- `private BindsModule()`  L23
### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel_HiltModules$KeyModule`
L28 · [class] public static final KeyModule · `com/gku/loginmodule/viewmodels/UserInfoFragmentViewModel_HiltModules.java`
注解：@Module

方法（2）：
- `private KeyModule()`  L29
- `String provide()`  L34 @Provides @IntoSet
    - 体内字面量："com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel"
### `com.gku.loginmodule.viewmodels.UserInfoViewModel`
L11 · [class] public UserInfoViewModel · extends `BaseViewModel` · `com/gku/loginmodule/viewmodels/UserInfoViewModel.java`

字段/常量（3）：
- `String TAG = "UserInfoViewModel"`  L12
- `GKUUserRepository gkuUserRepository`  L13
- `MutableLiveData<GKUUser> localGkuUser`  L14

方法（4）：
- `public UserInfoViewModel()`  L16
- `public UserInfoViewModel(GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository)`  L22 @Inject
- `void getLocalGKUUser()`  L28
- `void deleteLocalAllGKUUser(UserInfoActivity mActivity, boolean isJumpToLoginFragment)`  L32
### `com.gku.loginmodule.viewmodels.UserInfoViewModel_Factory`
L9 · [class] public final UserInfoViewModel_Factory · implements `Factory<UserInfoViewModel>` · `com/gku/loginmodule/viewmodels/UserInfoViewModel_Factory.java`

字段/常量（2）：
- `Provider<GKUUserRepository> gkuUserRepositoryProvider`  L10
- `Provider<GetLanguageListRepository> languageListRepositoryProvider`  L11

方法（4）：
- `public UserInfoViewModel_Factory(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L13
- `UserInfoViewModel get()`  L19 @Override
- `UserInfoViewModel_Factory create(Provider<GKUUserRepository> gkuUserRepositoryProvider, Provider<GetLanguageListRepository> languageListRepositoryProvider)`  L23
- `UserInfoViewModel newInstance(GKUUserRepository gkuUserRepository, GetLanguageListRepository languageListRepository)`  L27