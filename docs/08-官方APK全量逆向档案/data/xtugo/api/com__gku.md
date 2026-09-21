# XTU GO — 类与成员明细：com.gku

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 12 个文件 / 58 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.BaseApplication`
L27 · [class] public BaseApplication · extends `Hilt_BaseApplication` · `com/gku/BaseApplication.java`
注解：@HiltAndroidApp

字段/常量（12）：
- `boolean IsSkip = false`  L28
- `String TAG = "ActionCamApp"`  L29
- `AppDatabase db`  L30
- `Context mContext`  L31
- `boolean isSetDelayedRecordingTime = false`  L34
- `ArrayList<String> mArrayPathList = null`  L35
- `ArrayList<Integer> mArrayInt = null`  L36
- `int count = 0`  L37
- `int activityCount = 0`  L38
- `List<Activity> list = activityList`  L110
- `List<Activity> list = activityList`  L139
- `Activity activity = null`  L144

方法（22）：
- `void onCreate()`  L41 @Override
    - 体内字面量："logs"
- `void run()`  L49 @Override
    - 体内字面量："XUYGO"
- `void onActivityCreated(Activity activity, Bundle bundle)`  L60 @Override
    - 体内字面量：">>>>>>>>>>>>>>>>onActivityCreated"
- `void onActivityStarted(Activity activity)`  L69 @Override
    - 体内字面量：">>>>>>>>>>>>>>>>Appåå°åå°"
- `void onActivityResumed(Activity activity)`  L77 @Override
    - 体内字面量：">>>>>>>>>>>>>>>>onActivityResumed"
- `void onActivityPaused(Activity activity)`  L82 @Override
    - 体内字面量：">>>>>>>>>>>>>>>>onActivityPaused"
- `void onActivityStopped(Activity activity)`  L87 @Override
    - 体内字面量：">>>>>>>>>>>>>>>>Appåå°åå°"
- `void onActivitySaveInstanceState(Activity activity, Bundle bundle)`  L95 @Override
    - 体内字面量：">>>>>>>>>>>>>>>>onActivitySaveInstanceState"
- `void onActivityDestroyed(Activity activity)`  L100 @Override
    - 体内字面量：">>>>>>>>>>>>>>>>onActivityDestroyed"
- `void finishAllActivity()`  L109
- `void finishActivityCollection(List<Activity> collection)`  L121
- `void finishByActivityName(Activity activity)`  L128
- `Activity getTopActivity()`  L135
- `void finishByActivityClass(Class<?> cls)`  L143
- `void setPathList(ArrayList<String> ListImage)`  L153
- `ArrayList<String> getPathList()`  L157
- `void setIntArray(ArrayList<Integer> ListIntArray)`  L161
- `ArrayList<Integer> getIntArray()`  L165
- `Context getContext()`  L169
- `AppDatabase getDb()`  L173
- `String getPhotoDirectory()`  L178 @Override
- `String getVideoDirectory()`  L183 @Override
### `com.gku.BaseApplication_ComponentTreeDeps`
L4 · [class] public final BaseApplication_ComponentTreeDeps · `com/gku/BaseApplication_ComponentTreeDeps.java`
### `com.gku.BaseApplication_GeneratedInjector`
L4 · [interface] public BaseApplication_GeneratedInjector · `com/gku/BaseApplication_GeneratedInjector.java`

方法（1）：
- `void injectBaseApplication(BaseApplication baseApplication)`  L5
### `com.gku.BaseApplication_HiltComponents`
L66 · [class] public final BaseApplication_HiltComponents · `com/gku/BaseApplication_HiltComponents.java`

方法（1）：
- `private BaseApplication_HiltComponents()`  L171
### `com.gku.BaseApplication_HiltComponents$ActivityC`
L69 · [class] public static abstract ActivityC · implements `HomeActivity_GeneratedInjector, AnnouncementLatestActivity_GeneratedInjector, Login_Register_Activity_GeneratedInjector, Report_Feedback_Activity_GeneratedInjector, UserInfoActivity_GeneratedInjector, WebViewActivity_GeneratedInjector, ActivityComponent, DefaultViewModelFactories.ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, FragmentComponentManager.FragmentComponentBuilderEntryPoint, ViewComponentManager.ViewComponentBuilderEntryPoint, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent(modules = {FragmentCBuilderModule.class, ViewCBuilderModule.class, HiltWrapper_ActivityModule.class, HiltWrapper_DefaultViewModelFactories_ActivityModule.class})
### `com.gku.BaseApplication_HiltComponents$ActivityC$Builder`
L72 · [interface] Builder · extends `ActivityComponentBuilder` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent.Builder
### `com.gku.BaseApplication_HiltComponents$ActivityCBuilderModule`
L77 · [interface] ActivityCBuilderModule · `com/gku/BaseApplication_HiltComponents.java`
注解：@Module(subcomponents = {ActivityC.class})

方法（1）：
- `ActivityComponentBuilder bind(ActivityC.Builder builder)`  L79 @Binds
### `com.gku.BaseApplication_HiltComponents$ActivityRetainedC`
L83 · [class] public static abstract ActivityRetainedC · implements `ActivityRetainedComponent, ActivityComponentManager.ActivityComponentBuilderEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent(modules = {ActivityCBuilderModule.class, ViewModelCBuilderModule.class, DeleteAccountViewModel_HiltModules.KeyModule.class, HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class, LoginFragmentViewModel_HiltModules.KeyModule.cla)
### `com.gku.BaseApplication_HiltComponents$ActivityRetainedC$Builder`
L86 · [interface] Builder · extends `ActivityRetainedComponentBuilder` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent.Builder
### `com.gku.BaseApplication_HiltComponents$ActivityRetainedCBuilderModule`
L91 · [interface] ActivityRetainedCBuilderModule · `com/gku/BaseApplication_HiltComponents.java`
注解：@Module(subcomponents = {ActivityRetainedC.class})

方法（1）：
- `ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder)`  L93 @Binds
### `com.gku.BaseApplication_HiltComponents$FragmentC`
L97 · [class] public static abstract FragmentC · implements `DeleteAccountFragment_GeneratedInjector, LoginFragment_GeneratedInjector, ModifyPasswordFragment_GeneratedInjector, OperationFailFragment_GeneratedInjector, OperationSuccessFragment_GeneratedInjector, PhoneNumberFragment_GeneratedInjector, RegisterFragment_GeneratedInjector, ReportFeedbackFragment_GeneratedInjector, UserCenterNewFragment_GeneratedInjector, UserInfoFragment_GeneratedInjector, FragmentComponent, DefaultViewModelFactories.FragmentEntryPoint, ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent(modules = {ViewWithFragmentCBuilderModule.class})
### `com.gku.BaseApplication_HiltComponents$FragmentC$Builder`
L100 · [interface] Builder · extends `FragmentComponentBuilder` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent.Builder
### `com.gku.BaseApplication_HiltComponents$FragmentCBuilderModule`
L105 · [interface] FragmentCBuilderModule · `com/gku/BaseApplication_HiltComponents.java`
注解：@Module(subcomponents = {FragmentC.class})

方法（1）：
- `FragmentComponentBuilder bind(FragmentC.Builder builder)`  L107 @Binds
### `com.gku.BaseApplication_HiltComponents$ServiceC`
L111 · [class] public static abstract ServiceC · implements `ServiceComponent, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent
### `com.gku.BaseApplication_HiltComponents$ServiceC$Builder`
L114 · [interface] Builder · extends `ServiceComponentBuilder` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent.Builder
### `com.gku.BaseApplication_HiltComponents$ServiceCBuilderModule`
L119 · [interface] ServiceCBuilderModule · `com/gku/BaseApplication_HiltComponents.java`
注解：@Module(subcomponents = {ServiceC.class})

方法（1）：
- `ServiceComponentBuilder bind(ServiceC.Builder builder)`  L121 @Binds
### `com.gku.BaseApplication_HiltComponents$SingletonC`
L126 · [class] public static abstract SingletonC · implements `BaseApplication_GeneratedInjector, MVUtilsEntryPoint, FragmentGetContextFix.FragmentGetContextFixEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Component(modules = {ApplicationContextModule.class, ActivityRetainedCBuilderModule.class, ServiceCBuilderModule.class, HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class, MVUtils.class}) @Singleton
### `com.gku.BaseApplication_HiltComponents$ViewC`
L130 · [class] public static abstract ViewC · implements `ViewComponent, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent
### `com.gku.BaseApplication_HiltComponents$ViewC$Builder`
L133 · [interface] Builder · extends `ViewComponentBuilder` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent.Builder
### `com.gku.BaseApplication_HiltComponents$ViewCBuilderModule`
L138 · [interface] ViewCBuilderModule · `com/gku/BaseApplication_HiltComponents.java`
注解：@Module(subcomponents = {ViewC.class})

方法（1）：
- `ViewComponentBuilder bind(ViewC.Builder builder)`  L140 @Binds
### `com.gku.BaseApplication_HiltComponents$ViewModelC`
L144 · [class] public static abstract ViewModelC · implements `ViewModelComponent, HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent(modules = {DeleteAccountViewModel_HiltModules.BindsModule.class, HiltWrapper_HiltViewModelFactory_ViewModelModule.class, LoginFragmentViewModel_HiltModules.BindsModule.class, LoginRegisterViewModel_HiltModules.BindsModule.class, ModifyPassw)
### `com.gku.BaseApplication_HiltComponents$ViewModelC$Builder`
L147 · [interface] Builder · extends `ViewModelComponentBuilder` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent.Builder
### `com.gku.BaseApplication_HiltComponents$ViewModelCBuilderModule`
L152 · [interface] ViewModelCBuilderModule · `com/gku/BaseApplication_HiltComponents.java`
注解：@Module(subcomponents = {ViewModelC.class})

方法（1）：
- `ViewModelComponentBuilder bind(ViewModelC.Builder builder)`  L154 @Binds
### `com.gku.BaseApplication_HiltComponents$ViewWithFragmentC`
L158 · [class] public static abstract ViewWithFragmentC · implements `ViewWithFragmentComponent, GeneratedComponent` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent
### `com.gku.BaseApplication_HiltComponents$ViewWithFragmentC$Builder`
L161 · [interface] Builder · extends `ViewWithFragmentComponentBuilder` · `com/gku/BaseApplication_HiltComponents.java`
注解：@Subcomponent.Builder
### `com.gku.BaseApplication_HiltComponents$ViewWithFragmentCBuilderModule`
L166 · [interface] ViewWithFragmentCBuilderModule · `com/gku/BaseApplication_HiltComponents.java`
注解：@Module(subcomponents = {ViewWithFragmentC.class})

方法（1）：
- `ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder)`  L168 @Binds
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC`
L84 · [class] public final DaggerBaseApplication_HiltComponents_SingletonC · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

方法（2）：
- `private DaggerBaseApplication_HiltComponents_SingletonC()`  L85
- `Builder builder()`  L88
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ActivityCBuilder`
L137 · [class] private static final ActivityCBuilder · implements `BaseApplication_HiltComponents.ActivityC.Builder` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（3）：
- `Activity activity`  L138
- `ActivityRetainedCImpl activityRetainedCImpl`  L139
- `SingletonCImpl singletonCImpl`  L140

方法（3）：
- `private ActivityCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl)`  L142
- `ActivityCBuilder activity(Activity activity)`  L148 @Override
- `BaseApplication_HiltComponents.ActivityC build()`  L154 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ActivityCImpl`
L413 · [class] private static final ActivityCImpl · extends `BaseApplication_HiltComponents.ActivityC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（3）：
- `ActivityCImpl activityCImpl`  L414
- `ActivityRetainedCImpl activityRetainedCImpl`  L415
- `SingletonCImpl singletonCImpl`  L416

方法（16）：
- `void injectAnnouncementLatestActivity(AnnouncementLatestActivity announcementLatestActivity)`  L419 @Override
- `void injectWebViewActivity(WebViewActivity webViewActivity)`  L423 @Override
- `private ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam)`  L426
- `void injectHomeActivity(HomeActivity homeActivity)`  L433 @Override
- `void injectLogin_Register_Activity(Login_Register_Activity login_Register_Activity)`  L438 @Override
- `void injectReport_Feedback_Activity(Report_Feedback_Activity report_Feedback_Activity)`  L443 @Override
- `void injectUserInfoActivity(UserInfoActivity userInfoActivity)`  L448 @Override
- `DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory()`  L453 @Override
- `Set<String> getViewModelKeys()`  L458 @Override
- `ViewModelComponentBuilder getViewModelComponentBuilder()`  L463 @Override
- `FragmentComponentBuilder fragmentComponentBuilder()`  L468 @Override
- `ViewComponentBuilder viewComponentBuilder()`  L473 @Override
- `HomeActivity injectHomeActivity2(HomeActivity instance)`  L477
- `Login_Register_Activity injectLogin_Register_Activity2(Login_Register_Activity instance)`  L482
- `Report_Feedback_Activity injectReport_Feedback_Activity2(Report_Feedback_Activity instance)`  L487
- `UserInfoActivity injectUserInfoActivity2(UserInfoActivity instance)`  L492
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ActivityRetainedCBuilder`
L124 · [class] private static final ActivityRetainedCBuilder · implements `BaseApplication_HiltComponents.ActivityRetainedC.Builder` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（1）：
- `SingletonCImpl singletonCImpl`  L125

方法（2）：
- `private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl)`  L127
- `BaseApplication_HiltComponents.ActivityRetainedC build()`  L132 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ActivityRetainedCImpl`
L569 · [class] private static final ActivityRetainedCImpl · extends `BaseApplication_HiltComponents.ActivityRetainedC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（3）：
- `ActivityRetainedCImpl activityRetainedCImpl`  L570
- `Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider`  L571
- `SingletonCImpl singletonCImpl`  L572

方法（4）：
- `private ActivityRetainedCImpl(SingletonCImpl singletonCImpl)`  L574
- `void initialize()`  L580
- `ActivityComponentBuilder activityComponentBuilder()`  L585 @Override
- `ActivityRetainedLifecycle getActivityRetainedLifecycle()`  L590 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ActivityRetainedCImpl$SwitchingProvider`
L594 · [class] private static final SwitchingProvider · implements `Provider<T>` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（3）：
- `ActivityRetainedCImpl activityRetainedCImpl`  L595
- `int id`  L596
- `SingletonCImpl singletonCImpl`  L597

方法（2）：
- `T get()`  L606 @Override
- `throw new AssertionError(this.id)`  L610
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$Builder`
L92 · [class] public static final Builder · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（2）：
- `ApplicationContextModule applicationContextModule`  L93
- `MVUtils mVUtils`  L94

方法（5）：
- `private Builder()`  L96
- `Builder applicationContextModule(ApplicationContextModule applicationContextModule)`  L99
- `Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule)`  L105 @Deprecated
- `Builder mVUtils(MVUtils mVUtils)`  L110
- `BaseApplication_HiltComponents.SingletonC build()`  L115
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$FragmentCBuilder`
L160 · [class] private static final FragmentCBuilder · implements `BaseApplication_HiltComponents.FragmentC.Builder` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（4）：
- `ActivityCImpl activityCImpl`  L161
- `ActivityRetainedCImpl activityRetainedCImpl`  L162
- `Fragment fragment`  L163
- `SingletonCImpl singletonCImpl`  L164

方法（3）：
- `private FragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl)`  L166
- `FragmentCBuilder fragment(Fragment fragment)`  L173 @Override
- `BaseApplication_HiltComponents.FragmentC build()`  L179 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$FragmentCImpl`
L305 · [class] private static final FragmentCImpl · extends `BaseApplication_HiltComponents.FragmentC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（4）：
- `ActivityCImpl activityCImpl`  L306
- `ActivityRetainedCImpl activityRetainedCImpl`  L307
- `FragmentCImpl fragmentCImpl`  L308
- `SingletonCImpl singletonCImpl`  L309

方法（18）：
- `void injectDeleteAccountFragment(DeleteAccountFragment deleteAccountFragment)`  L312 @Override
- `void injectModifyPasswordFragment(ModifyPasswordFragment modifyPasswordFragment)`  L316 @Override
- `void injectPhoneNumberFragment(PhoneNumberFragment phoneNumberFragment)`  L320 @Override
- `void injectRegisterFragment(RegisterFragment registerFragment)`  L324 @Override
- `void injectUserInfoFragment(UserInfoFragment userInfoFragment)`  L328 @Override
- `private FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, Fragment fragmentParam)`  L331
- `void injectLoginFragment(LoginFragment loginFragment)`  L339 @Override
- `void injectOperationFailFragment(OperationFailFragment operationFailFragment)`  L344 @Override
- `void injectOperationSuccessFragment(OperationSuccessFragment operationSuccessFragment)`  L349 @Override
- `void injectReportFeedbackFragment(ReportFeedbackFragment reportFeedbackFragment)`  L354 @Override
- `void injectUserCenterNewFragment(UserCenterNewFragment userCenterNewFragment)`  L359 @Override
- `DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory()`  L364 @Override
- `ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder()`  L369 @Override
- `LoginFragment injectLoginFragment2(LoginFragment instance)`  L373
- `OperationFailFragment injectOperationFailFragment2(OperationFailFragment instance)`  L378
- `OperationSuccessFragment injectOperationSuccessFragment2(OperationSuccessFragment instance)`  L383
- `ReportFeedbackFragment injectReportFeedbackFragment2(ReportFeedbackFragment instance)`  L388
- `UserCenterNewFragment injectUserCenterNewFragment2(UserCenterNewFragment instance)`  L393
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ServiceCBuilder`
L268 · [class] private static final ServiceCBuilder · implements `BaseApplication_HiltComponents.ServiceC.Builder` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（2）：
- `Service service`  L269
- `SingletonCImpl singletonCImpl`  L270

方法（3）：
- `private ServiceCBuilder(SingletonCImpl singletonCImpl)`  L272
- `ServiceCBuilder service(Service service)`  L277 @Override
- `BaseApplication_HiltComponents.ServiceC build()`  L283 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ServiceCImpl`
L615 · [class] private static final ServiceCImpl · extends `BaseApplication_HiltComponents.ServiceC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（2）：
- `ServiceCImpl serviceCImpl`  L616
- `SingletonCImpl singletonCImpl`  L617

方法（1）：
- `private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam)`  L619
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$SingletonCImpl`
L625 · [class] private static final SingletonCImpl · extends `BaseApplication_HiltComponents.SingletonC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（4）：
- `ApplicationContextModule applicationContextModule`  L626
- `Provider<MVUtils> getMVUtilsProvider`  L627
- `MVUtils mVUtils`  L628
- `SingletonCImpl singletonCImpl`  L629

方法（7）：
- `void injectBaseApplication(BaseApplication baseApplication)`  L632 @Override
- `private SingletonCImpl(ApplicationContextModule applicationContextModuleParam, MVUtils mVUtilsParam)`  L635
- `void initialize(final ApplicationContextModule applicationContextModuleParam, final MVUtils mVUtilsParam)`  L642
- `MVUtils getMVUtils()`  L647 @Override
- `Set<Boolean> getDisableFragmentGetContextFix()`  L652 @Override
- `ActivityRetainedComponentBuilder retainedComponentBuilder()`  L657 @Override
- `ServiceComponentBuilder serviceComponentBuilder()`  L662 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$SingletonCImpl$SwitchingProvider`
L666 · [class] private static final SwitchingProvider · implements `Provider<T>` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（2）：
- `int id`  L667
- `SingletonCImpl singletonCImpl`  L668

方法（2）：
- `T get()`  L676 @Override
- `throw new AssertionError(this.id)`  L680
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ViewCBuilder`
L212 · [class] private static final ViewCBuilder · implements `BaseApplication_HiltComponents.ViewC.Builder` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（4）：
- `ActivityCImpl activityCImpl`  L213
- `ActivityRetainedCImpl activityRetainedCImpl`  L214
- `SingletonCImpl singletonCImpl`  L215
- `View view`  L216

方法（3）：
- `private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl)`  L218
- `ViewCBuilder view(View view)`  L225 @Override
- `BaseApplication_HiltComponents.ViewC build()`  L231 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ViewCImpl`
L399 · [class] private static final ViewCImpl · extends `BaseApplication_HiltComponents.ViewC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（4）：
- `ActivityCImpl activityCImpl`  L400
- `ActivityRetainedCImpl activityRetainedCImpl`  L401
- `SingletonCImpl singletonCImpl`  L402
- `ViewCImpl viewCImpl`  L403

方法（1）：
- `private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, View viewParam)`  L405
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ViewModelCBuilder`
L237 · [class] private static final ViewModelCBuilder · implements `BaseApplication_HiltComponents.ViewModelC.Builder` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（4）：
- `ActivityRetainedCImpl activityRetainedCImpl`  L238
- `SavedStateHandle savedStateHandle`  L239
- `SingletonCImpl singletonCImpl`  L240
- `ViewModelLifecycle viewModelLifecycle`  L241

方法（4）：
- `private ViewModelCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl)`  L243
- `ViewModelCBuilder savedStateHandle(SavedStateHandle handle)`  L249 @Override
- `ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle)`  L255 @Override
- `BaseApplication_HiltComponents.ViewModelC build()`  L261 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ViewModelCImpl`
L498 · [class] private static final ViewModelCImpl · extends `BaseApplication_HiltComponents.ViewModelC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（10）：
- `ActivityRetainedCImpl activityRetainedCImpl`  L499
- `Provider<DeleteAccountViewModel> deleteAccountViewModelProvider`  L500
- `Provider<LoginFragmentViewModel> loginFragmentViewModelProvider`  L501
- `Provider<LoginRegisterViewModel> loginRegisterViewModelProvider`  L502
- `Provider<ModifyPasswordFragmentViewModel> modifyPasswordFragmentViewModelProvider`  L503
- `Provider<PhoneNumberFragmentViewModel> phoneNumberFragmentViewModelProvider`  L504
- `Provider<RegisterFragmentViewModel> registerFragmentViewModelProvider`  L505
- `SingletonCImpl singletonCImpl`  L506
- `Provider<UserInfoFragmentViewModel> userInfoFragmentViewModelProvider`  L507
- `ViewModelCImpl viewModelCImpl`  L508

方法（3）：
- `private ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam)`  L510
- `void initialize(final SavedStateHandle savedStateHandleParam, final ViewModelLifecycle viewModelLifecycleParam)`  L517
- `Map<String, Provider<ViewModel>> getHiltViewModelMap()`  L528 @Override
    - 体内字面量："com.gku.loginmodule.viewmodels.DeleteAccountViewModel" · "com.gku.loginmodule.viewmodels.LoginFragmentViewModel" · "com.gku.loginmodule.viewmodels.LoginRegisterViewModel" · "com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel" · "com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel" · "com.gku.loginmodule.viewmodels.RegisterFragmentViewModel" · "com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel"
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ViewModelCImpl$SwitchingProvider`
L532 · [class] private static final SwitchingProvider · implements `Provider<T>` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（4）：
- `ActivityRetainedCImpl activityRetainedCImpl`  L533
- `int id`  L534
- `SingletonCImpl singletonCImpl`  L535
- `ViewModelCImpl viewModelCImpl`  L536

方法（2）：
- `T get()`  L546 @Override
- `throw new AssertionError(this.id)`  L563
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ViewWithFragmentCBuilder`
L185 · [class] private static final ViewWithFragmentCBuilder · implements `BaseApplication_HiltComponents.ViewWithFragmentC.Builder` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（5）：
- `ActivityCImpl activityCImpl`  L186
- `ActivityRetainedCImpl activityRetainedCImpl`  L187
- `FragmentCImpl fragmentCImpl`  L188
- `SingletonCImpl singletonCImpl`  L189
- `View view`  L190

方法（3）：
- `private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl)`  L192
- `ViewWithFragmentCBuilder view(View view)`  L200 @Override
- `BaseApplication_HiltComponents.ViewWithFragmentC build()`  L206 @Override
### `com.gku.DaggerBaseApplication_HiltComponents_SingletonC$ViewWithFragmentCImpl`
L289 · [class] private static final ViewWithFragmentCImpl · extends `BaseApplication_HiltComponents.ViewWithFragmentC` · `com/gku/DaggerBaseApplication_HiltComponents_SingletonC.java`

字段/常量（5）：
- `ActivityCImpl activityCImpl`  L290
- `ActivityRetainedCImpl activityRetainedCImpl`  L291
- `FragmentCImpl fragmentCImpl`  L292
- `SingletonCImpl singletonCImpl`  L293
- `ViewWithFragmentCImpl viewWithFragmentCImpl`  L294

方法（1）：
- `private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl, View viewParam)`  L296
### `com.gku.G`
L11 · [class] public G · `com/gku/G.java`

字段/常量（12）：
- `String TAG = "G"`  L12
- `File localAppDataPath`  L13
- `File localDCIMActionCamPhotoDataPath`  L14
- `File localDCIMActionCamSDVideoDataPath`  L15
- `File localDCIMActionCamVideoDataPath`  L16
- `File localDCIMDashCamPhotoDataPath`  L17
- `File localDCIMDashCamVideoDataPath`  L18
- `File localDCIMDataPath`  L19
- `File localDCIMPhotoDataPath`  L20
- `File localDCIMVideoDataPath`  L21
- `boolean sLoaded`  L22
- `String systemLanguage`  L23

方法（5）：
- `void initLocalAppDataPath(Context context)`  L25
- `void initLocalDCIMDataPath(Context context)`  L31
- `void getSystemLanguages(Context mContext)`  L43
- `void loadLibrarys()`  L51
- `boolean loadLibs()`  L55
    - 体内字面量："phone_type:"
### `com.gku.Hilt_BaseApplication`
L11 · [class] abstract Hilt_BaseApplication · extends `App implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/Hilt_BaseApplication.java`

字段/常量（1）：
- `boolean injected = false`  L12

方法（5）：
- `Object get()`  L15 @Override
- `ApplicationComponentManager componentManager()`  L24 @Override
- `Object generatedComponent()`  L29 @Override
- `void onCreate()`  L34 @Override
- `void hiltInternalInject()`  L39
### `com.gku.Hilt_HomeActivity`
L13 · [class] abstract Hilt_HomeActivity · extends `BaseActivateActivity implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/Hilt_HomeActivity.java`

字段/常量（2）：
- `ActivityComponentManager componentManager`  L14
- `boolean injected = false`  L16

方法（7）：
- `void _initHiltInternal()`  L22
- `void onContextAvailable(Context context)`  L25 @Override
- `Object generatedComponent()`  L32 @Override
- `ActivityComponentManager createComponentManager()`  L36
- `ActivityComponentManager componentManager()`  L41 @Override
- `void inject()`  L52
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L61 @Override
### `com.gku.HomeActivity`
L170 · [class] public HomeActivity · extends `Hilt_HomeActivity implements IChannelListener, UpgradeInterface, IHomeView, DeviceVersionManager.OnDownloadMessageListener` · implements `IChannelListener, UpgradeInterface, IHomeView, DeviceVersionManager.OnDownloadMessageListener` · `com/gku/HomeActivity.java`

字段/常量（123）：
- `String CALLBACK_SCANWIFI_RESULT = "df-efg-32-5-rg-dfg"`  L171
- `int CODE_SCAN_WIFI = 321`  L172
- `String INTENT_RTMP_TASK = "INTENT_RTMP_TASK"`  L173
- `String READY_FOR_RTMP = "ready..."`  L174
- `String STREAMING_FOR_RTMP = "streaming..."`  L175
- `String TAG = "HomeActivity"`  L176
- `String WAITING_FOR_RTMP = "waiting..."`  L177
- `int WHAT_AMBA_RECONNECT_FAILURE = 1141548`  L178
- `int WHAT_AMBA_RECONNECT_SUCCESS = 1141549`  L179
- `boolean isTryAgain = true`  L180
- `int resultCode = 20221112`  L181
- `SharedPreferences.Editor activityEditor`  L182
- `TextView albumText`  L183
- `List<BottomButtomItem> bottomButtomItemList`  L184
- `BottomButtomItem bottomCamera`  L185
- `LinearLayout bottomLinear`  L186
- `BottomButtomItem bottomPhoto`  L187
- `ConstraintLayout bottomPopup`  L188
- `RelativeLayout bottomRela`  L189
- `BottomButtomItem bottomUser`  L190
- `BottomButtomItem bottomXtuPlus`  L191
- `AmbaConnector.CallbackSession callbackSession`  L192
- `ImageView centerLogo`  L193
- `int curIndex`  L194
- `Button deleteFiles`  L195
- `String deviceSsid`  L196
- `SharedPreferences.Editor edit`  L197
- `ExecutorService executorService`  L198
- `FragmentConnectedCamera fragmentConnectedCamera`  L199
- `FragmentDisConnectCamera fragmentDisConnectCamera`  L200
- `List<Fragment> fragmentList`  L201
- `FragmentNewAlbum fragmentNewAlbum`  L202
- `ImageView icBack`  L203
- `ImageView icSetting`  L204
- `boolean isCheckedAppVersion`  L205
- `boolean isConnectedANetwork`  L206
- `boolean isFirstCheckPermissions`  L207
- `boolean isHomeActivityFirstOpen`  L208
- `boolean isShow`  L209
- `ImageView ivAdd`  L210
- `ImageView ivEnterSelectAll`  L211
- `ImageView ivQuitSelectAll`  L212
- `ImageView iv_bluetooth_icon`  L213
- `ImageView iv_upgrade`  L214
- `long lastBackPressedTime`  L215
- `int lastIndex`  L216
- `long lastJumpTime`  L217
- `LinearLayoutShape layoutRed`  L218
- `RelativeLayout layoutSetting`  L219
- `LoadingDialog loadingDialog`  L220
- `RelativeLayout mActivityHome`  L221
- `Context mContext`  L222
- `ViewPager mFvpager`  L223
- `Handler mHandler`  L224
- `HomeActivityViewModel mViewModel`  L225
- `MVUtils mvUtils`  L228 @Inject
- `ConnectivityManager.NetworkCallback networkCallback`  L229
- `PagerFragmentNewAdapter pagerFragmentNewAdapter`  L230
- `String[] permissionList2`  L231
- `String[] permissionList3`  L232
- `String prefsName`  L233
- `String previewFlipValue`  L234
- `ProgressDialog progressDialog`  L235
- `String requestLanguage`  L236
- `List<String> scanList`  L237
- `Button selectAllFiles`  L238
- `LinearLayout selectFilesLayout`  L239
- `SelectPopupWindow selectPopupWindow`  L240
- `RTMPBean sendBufWithRTMP`  L241
- `SharedPreferences sharedPreferences`  L242
- `RelativeLayout titleLayout`  L243
- `ConstraintLayout topPopupList`  L244
- `TextView tvSelectAllText`  L245
- `TextView tvUnSelectAllText`  L246
- `TextView tvUserCenter`  L247
- `TextView tvXTUPlus`  L248
- `UpgradePresenter upgradePresenter`  L249
- `UpgradeViewManager upgradeViewManager`  L250
- `UserCenterNewFragment userCenterNewFragment`  L251
- `FragmentXTUPlus xtuPlusFragment`  L252
- `int currentPosition = -1`  L419
- `boolean isSwipeRight = true`  L420
- `int i = this.currentPosition`  L428
- `HomeActivity homeActivity = HomeActivity.this`  L450
- `HomeActivity homeActivity2 = HomeActivity.this`  L464
- `HomeActivity homeActivity3 = HomeActivity.this`  L475
- `HomeActivity homeActivity4 = HomeActivity.this`  L486
- `HomeActivity homeActivity5 = HomeActivity.this`  L496
- `boolean unused = HomeActivity.this.isFirstCheckPermissions`  L525
- `HomeActivity homeActivity = HomeActivity.this`  L546
- `int i = 0`  L919
- `String str = permissions[i]`  L924
- `String str2 = permissions[i2]`  L956
- `String str3 = permissions[i3]`  L989
- `String str4 = permissions[i]`  L1021
- `String stringExtra = "<binary/metadata>"`  L1067
- `WifiConfiguration next`  L1084
- `ProgressDialog progressDialog = this.progressDialog`  L1164
- `HomeActivity homeActivity = HomeActivity.this`  L1183
- `String str = array[0]`  L1190
- `SelectPopupWindow selectPopupWindow = this.selectPopupWindow`  L1374
- `SelectPopupWindow selectPopupWindow = this.selectPopupWindow`  L1415
- `SelectPopupWindow selectPopupWindow = this.selectPopupWindow`  L1429
- `HomeActivity homeActivity = HomeActivity.this`  L1445
- `HomeActivity homeActivity2 = HomeActivity.this`  L1446
- `String str = OSSConstants.PROTOCOL_HTTP + connectIp + "/cgi-bin/hi3510/"`  L1708
- `HomeActivity homeActivity = HomeActivity.this`  L1778
- `String string = "<binary/metadata>"`  L1799
- `SelectPopupWindow selectPopupWindow = this.selectPopupWindow`  L1895
- `SelectPopupWindow selectPopupWindow2 = this.selectPopupWindow`  L1905
- `SelectPopupWindow selectPopupWindow3 = this.selectPopupWindow`  L1915
- `SelectPopupWindow selectPopupWindow4 = this.selectPopupWindow`  L1925
- `SelectPopupWindow selectPopupWindow5 = this.selectPopupWindow`  L1935
- `ImageView imageView = this.ivEnterSelectAll`  L1956
- `ImageView imageView2 = this.ivQuitSelectAll`  L1960
- `TextView textView = this.tvSelectAllText`  L1968
- `TextView textView2 = this.tvUnSelectAllText`  L1972
- `HomeActivity homeActivity = HomeActivity.this`  L2020
- `HomeActivity homeActivity2 = HomeActivity.this`  L2025
- `HomeActivity homeActivity = HomeActivity.this`  L2043
- `HomeActivity homeActivity2 = HomeActivity.this`  L2048
- `Network activeNetwork`  L2063
- `NetworkCapabilities networkCapabilities`  L2064

方法（130）：
- `void lambda$onCreate$5(View view)`  L258
- `public HomeActivity()`  L261
    - 体内字面量："APP-FirstOpenCheck" · "modelNameAndSoftVersion" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE"
- `void startHomeActivity(Context context)`  L280
- `void onCreate(Bundle savedInstanceState)`  L285 @Override
- `void onClick(View view)`  L332 @Override
- `void onClick(View view)`  L338 @Override
- `void onClick(View view)`  L345 @Override
- `void onClick(View view)`  L351 @Override
- `void onClick(View view)`  L357 @Override
- `void onClick(View view)`  L363 @Override
- `void onClick(View view)`  L369 @Override
- `void onClick(View view)`  L375 @Override
    - 体内字面量："modelNameAndSoftVersion" · "isFirstCheckPermissions" · "isHomeActivityFirstOpen"
- `void onPageScrollStateChanged(int state)`  L423 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L427 @Override
- `void onPageSelected(int position)`  L440 @Override
- `void run()`  L524 @Override
- `void callback(Object o)`  L531 @Override
- `void onCurrentLifecycleOwnerDestroy()`  L538 @Override
- `void onAppStart()`  L542 @Override
    - 体内字面量："åºç¨è¿å¥åå° onAppStart"
- `void onAppStop()`  L552 @Override
    - 体内字面量："åºç¨è¿å¥åå° onAppStop"
- `void onAvailable()`  L558 @Override
    - 体内字面量："NetworkLifecyleUtils onAvailable" · "networkCallback-onAvailable> è¿æ¥å°çipï¼" · "192.168.0.1" · "networkCallback onAvailable å·²è¿æ¥çç½ç»ä¸æ¯ç¸æºï¼èæ¯ï¼"
- `void onLost()`  L579 @Override
    - 体内字面量："NetworkLifecyleUtils onLost"
- `void onUnavailable(boolean scan)`  L592 @Override
- `void lambda$onCreate$0(View view)`  L601
- `void lambda$onCreate$1(View view)`  L609
- `void lambda$onCreate$2(View view)`  L617
- `void lambda$onCreate$3(View view)`  L625
- `void lambda$onCreate$4(View view)`  L632
- `void lambda$onCreate$6(View view)`  L639
- `void lambda$onCreate$7(View view)`  L644
- `void connectFail_back2Home()`  L813
- `void onDeviceConnectSuccess(final String name)`  L832
    - 体内字面量："onDeviceConnectSuccess: "
- `void run()`  L836 @Override
- `void ossPost(final String mid)`  L842
- `CoroutineContext get$context()`  L846 @Override
- `void resumeWith(Object o)`  L851 @Override
- `void ossUpload(ApiResult<OssPostResult> r, String mid)`  L857
    - 体内字面量："application/octet-stream" · "callbackUrl" · "callbackBody" · "x:mid"
- `void onSuccess(PutObjectRequest request, PutObjectResult result)`  L873 @Override
    - 体内字面量："hyh oss onSuccess  æå"
- `void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException)`  L879 @Override
    - 体内字面量："hyh oss onFailure  å¤±è´¥"
- `void onResume()`  L894 @Override
    - 体内字面量："xs, " · "HomeActivity onResume modifyLastLiveStatus null " · "getLanguages"
- `void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)`  L917 @Override
- `void onClick(DialogInterface dialog, int which)`  L969 @Override
- `void onClick(DialogInterface dialog, int which)`  L974 @Override
    - 体内字面量："isHomeActivityFirstOpen"
- `void onClick(DialogInterface dialog, int which)`  L1004 @Override
- `void onClick(DialogInterface dialog, int which)`  L1010 @Override
    - 体内字面量："isHomeActivityFirstOpen"
- `void onPause()`  L1034 @Override
- `void onStop()`  L1042 @Override
- `void requestMediaManagerPermission()`  L1048
    - 体内字面量："android.settings.REQUEST_MANAGE_MEDIA"
- `void onWindowFocusChanged(boolean hasFocus)`  L1055 @Override
- `void onActivityResult(int requestCode, int resultCode2, Intent data)`  L1063 @Override
    - 体内字面量："networkCallback autoConnectWifi" · "============" · "   "
- `void connectByConfig(String ssid, String password, final ConnectCallback callback)`  L1083
- `void onNeedUpdateMsg(boolean needUpdate)`  L1131 @Override
- `WifiConfiguration createWifiConfig(String ssid, String password, int cipherType)`  L1139
    - 体内字面量："\"" · "\"" · "\"" · "\""
- `void showConnectingProgressDialog()`  L1147
- `void hideConnectingProgressDialog()`  L1153
- `void run()`  L1156 @Override
- `void lambda$hideConnectingProgressDialog$8()`  L1163
- `void onChannelEvent(int type, Object param, String... array)`  L1171 @Override
    - 体内字面量："onChannelEvent: type: " · "onChannelEvent: è·åsession\n"
- `void run()`  L1182 @Override
- `void updateConnectFragment(boolean isConnected, Boolean autoGo)`  L1198
    - 体内字面量："updateConnectFragment" · "Had Connected"
- `void run()`  L1213 @Override
    - 体内字面量："Not Connected" · "æ­å¼è¿æ¥äº" · "UpdateUI"
- `void setNewDefault()`  L1239
- `void onClick(View view)`  L1249 @Override
- `void onClick(View v)`  L1255 @Override
- `void onClick(View v)`  L1263 @Override
- `void onClick(View v)`  L1271 @Override
- `void lambda$setNewDefault$9(View view)`  L1345
- `void changeTitle(int index)`  L1351
- `void SelectAndUnSelect()`  L1395
- `void exitSelect(MessageFileEvent messageFileEvent)`  L1405
- `void enterSelect(MessageFileEvent messageFileEvent)`  L1423
- `void showFirmUpgrade()`  L1439
- `void onClick(View view)`  L1443 @Override
- `void upgradeCameraFirm(UpgradeModel model)`  L1456 @Override
    - 体内字面量："upgradeCameraFirm" · "modelNameAndSoftVersion" · "isAmba"
- `void jumpToSystemWifiSettings()`  L1471
    - 体内字面量："android.settings.WIFI_SETTINGS"
- `void setCurrentPage(int index)`  L1475
- `void bottomClick(int index)`  L1479
- `int resultColorID(int state)`  L1523
- `void setBottomClick(TextView mText, ImageView imageView, int imgID)`  L1564
- `void setTextNormalColor(TextView mText)`  L1569
- `void reMoveShard(TextView mText)`  L1573
- `void setBottomButtomItem(BottomButtomItem bottomButtomItem, int resID, int textID)`  L1577
- `void setDefaultBottom()`  L1585
- `void setBottomUserRedDot(boolean isShow, int curIndex)`  L1594
- `void checkConnectionDevice(boolean cam, final String connectIp)`  L1604
    - 体内字面量："checkConnectionDevice" · "123-> è¿æ¥çä¸æ¯ç¸æºè®¾å¤"
- `void run()`  L1614 @Override
- `Object runThread()`  L1622 @Override
    - 体内字面量："123-> ConnectThread  è¿å¨ç¸æº"
- `void connectDashCamera2(String connectIp, final Boolean retry, Boolean isAUtoGo)`  L1634
    - 体内字面量："icatch   retry=" · "/" · "ICatchParams.txt"
- `void run()`  L1639 @Override
- `void resumeWith(Object data)`  L1645 @Override
    - 体内字面量："connectTo" · "resumeWith" · " icatch connectTo has connected." · " icatch connectTo productName=" · " fwVersion=" · "modelName" · "softVersion" · "softVersion" · "isAmba"
- `CoroutineContext get$context()`  L1670 @Override
- `void resumeWith(Object o)`  L1675 @Override
- `void run()`  L1681 @Override
    - 体内字面量："connectTo icatch è¿æ¥å¤±è´¥  retry="
- `void run()`  L1691 @Override
- `CoroutineContext get$context()`  L1700 @Override
- `void connectActionCamera(String connectIp)`  L1707
- `void run()`  L1721 @Override
- `void onTrial()`  L1724 @Override
- `boolean onActivate()`  L1729 @Override
    - 体内字面量："è¿ä¸hisiæèsigmastarç¸æºäº" · "NewAPP"
- `void run()`  L1759 @Override
    - 体内字面量："-" · "modelName" · "softVersion" · "isAmba" · "editä¿å­äºæ°æ®" · "  "
- `void run()`  L1776 @Override
- `void getAmbaWifiName(final CameraInfors cameraInfors)`  L1785
- `void onFail(int code)`  L1788 @Override
- `void onSuccess(CmdResponseBean responseBean, String json)`  L1792 @Override
- `void getHisiWifiName(final CameraInfors cameraInfors)`  L1824
- `void onSuccess(Call call, String responseBody, Response response)`  L1827 @Override
    - 体内字面量："_" · "_"
- `void onFail(Call call, int code, String errorMsg)`  L1847 @Override
    - 体内字面量："xs, " · ":"
- `String guessDeviceIP()`  L1853
- `void onBackPressed()`  L1860 @Override
- `void onMessageEvent(MessageEventModel event)`  L1875 @Subscribe(threadMode = ThreadMode.MAIN)
- `void onMessageEvent(MessageFileEvent event)`  L1888 @Subscribe(threadMode = ThreadMode.MAIN)
- `void onMessageEvent(FlipMessageEvent event)`  L1948 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："onMessageEvent: previewFlipValue = "
- `void updateEnterQuitStatus(int v1, int v2)`  L1955
- `void updateSelectAllStatus(int gone, int visible)`  L1967
- `void selectedSize()`  L1978
- `void run()`  L1981 @Override
- `void selectedCircleSize(int size)`  L1992
- `void setShowTitleBar(boolean showTitleBar)`  L2000
    - 体内字面量："123->" · " setShowTitleBar  "
- `String getDeviceManufacturer()`  L2009
- `boolean checkAlbumPermission()`  L2013
- `void onClick(DialogInterface dialog, int which)`  L2019 @Override
- `void onClick(DialogInterface dialog, int which)`  L2031 @Override
- `void onClick(DialogInterface dialog, int which)`  L2042 @Override
- `void onClick(DialogInterface dialog, int which)`  L2054 @Override
- `boolean isNetworkAvailable(Context context)`  L2062
- `boolean isInternetReachable()`  L2069
- `Boolean call()`  L2075 @Override
    - 体内字面量："https://www.baidu.com" · "HEAD"
- `void jumpToPreviewActivity()`  L2095 @Override
    - 体内字面量："jumpToPreviewActivity: not activated, drop this jump"
- `void run()`  L2112 @Override
    - 体内字面量："jumpToPreviewActivity: " · "jumpToPreviewActivity: too soon, drop this jump"
- `void lambda$jumpToPreviewActivity$10()`  L2126
### `com.gku.HomeActivity_GeneratedInjector`
L4 · [interface] public HomeActivity_GeneratedInjector · `com/gku/HomeActivity_GeneratedInjector.java`

方法（1）：
- `void injectHomeActivity(HomeActivity homeActivity)`  L5
### `com.gku.HomeActivity_MembersInjector`
L8 · [class] public final HomeActivity_MembersInjector · implements `MembersInjector<HomeActivity>` · `com/gku/HomeActivity_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public HomeActivity_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<HomeActivity> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(HomeActivity instance)`  L20 @Override
- `void injectMvUtils(HomeActivity instance, MVUtils mvUtils)`  L24
### `com.gku.HomeActivity$AnonymousClass15`
L1280 · [class] AnonymousClass15 · implements `SelectPopupWindow.OnImageViewClickListener` · `com/gku/HomeActivity.java`

方法（8）：
- `void OnFavoritesClick()`  L1287 @Override
- `void OnDeleteClick()`  L1295 @Override
- `void onFavoritesYUTUproClick(final BottomButtomItem bottomButtomItem)`  L1301 @Override
- `void run()`  L1305 @Override
- `void onShareYUTUproClick(final BottomButtomItem bottomButtomItem)`  L1316 @Override
- `void run()`  L1320 @Override
- `void onDeleteYUTUproClick(final BottomButtomItem bottomButtomItem)`  L1331 @Override
- `void run()`  L1335 @Override
### `com.gku.HomeActivity$AnonymousClass4`
L649 · [class] AnonymousClass4 · implements `AmbaConnector.CallbackSession` · `com/gku/HomeActivity.java`

字段/常量（1）：
- `HomeActivity homeActivity = HomeActivity.this`  L801

方法（4）：
- `void onPushMsgReceive(String msg)`  L651 @Override
- `void onSuccess()`  L786 @Override
- `void onFail(int code)`  L791 @Override
    - 体内字面量："è¿æ¥Ambaï¼ä¼è¯åå»ºå¤±è´¥:"
- `void dealFail()`  L797
### `com.gku.HomeActivity$AnonymousClass4$AnonymousClass1`
L658 · [class] AnonymousClass1 · implements `AmbaConnector.Callback<CameraInfoResponseBean>` · `com/gku/HomeActivity.java`

字段/常量（2）：
- `int iLastIndexOf`  L664
- `String str = "G"`  L718

方法（14）：
- `void onSuccess(CameraInfoResponseBean responseBean, String json)`  L663 @Override
- `void onTrial()`  L668 @Override
- `void onFail(int code)`  L671 @Override
- `void onSuccess(CmdResponseBean responseBean2, String json2)`  L675 @Override
- `boolean onActivate()`  L681 @Override
- `void onFail(int code)`  L684 @Override
- `void onSuccess(CmdResponseBean responseBean2, String json2)`  L688 @Override
- `void onFail(int code)`  L696 @Override
- `void onSuccess(GetActivateStatusResposeBean responseBean2, String json2)`  L700 @Override
- `void run()`  L705 @Override
    - 体内字面量："è¿æ¥Ambaï¼å°è¯è·åç¸æºä¿¡æ¯æåï¼"
- `void goToNext(boolean success)`  L760 @Override
    - 体内字面量："FLIP"
- `void success()`  L767 @Override
    - 体内字面量："è·åç¿»è½¬ä¿¡æ¯æåï¼"
- `void failure(int code)`  L772 @Override
    - 体内字面量："è·åç¿»è½¬ä¿¡æ¯å¤±è´¥ï¼"
- `void onFail(int code)`  L779 @Override
    - 体内字面量："è¿æ¥Ambaï¼å°è¯è·åç¸æºä¿¡æ¯å¤±è´¥ï¼"
### `com.gku.HomeActivity$ConnectCallback`
L254 · [interface] public ConnectCallback · `com/gku/HomeActivity.java`

方法（1）：
- `void onResult(boolean success)`  L255
### `com.gku.SendSoftActivity`
L25 · [class] public SendSoftActivity · extends `BaseXtuGoActivity` · `com/gku/SendSoftActivity.java`

字段/常量（27）：
- `String filePath = "<binary/metadata>"`  L26
- `boolean isAmba = true`  L27
- `String modelName = "<binary/metadata>"`  L28
- `Socket socket`  L29
- `TextView tv_log`  L30
- `Button update_finish`  L31
- `int CODE_HISI_CREATESOCKET_FAIL = -100001`  L32
- `int CODE_HISI_WRITE_MSG_FAIL = -100002`  L33
- `int CODE_HISI_READ_FAIL = -100003`  L34
- `int CODE_HISI_RECV_MSG_FAIL = -100004`  L35
- `int CODE_HISI_SEND_SOFT_CANCEL = -100005`  L36
- `int CODE_HISI_CREATE_TCP_MSG_S_FAIL = -100006`  L37
- `int CODE_HISI_CREATE_WIRTE_DATA_FAIL = -100007`  L38
- `int CODE_HISI_CREATE_FILE_INPUT_STRAEM_FAIL = -100008`  L39
- `int CODE_HISI_CREATE_WIRTE_MD5_FAIL = -100009`  L40
- `SendSoftActivity sendSoftActivity = SendSoftActivity.this`  L89
- `byte[] bArr = new byte[72]`  L119
- `byte[] bArr2 = new byte[65536]`  L140
- `int i2 = 10`  L141
- `byte[] bArr3 = new byte[10]`  L142
- `byte[] bArr4 = new byte[10]`  L143
- `boolean z = true`  L144
- `int i3 = 0`  L145
- `int i4 = 0`  L146
- `byte[] bArr5 = bArr3`  L169
- `long j = i3`  L170
- `SendSoftActivity sendSoftActivity = SendSoftActivity.this`  L223

方法（15）：
- `void onDestroy()`  L51 @Override
- `void onCreate(Bundle savedInstanceState)`  L57 @Override
- `void onClick(View v)`  L66 @Override
- `void onRefreshSpeed(long bytesPerSecond)`  L74 @Override
- `void onSuccess()`  L78 @Override
- `void onProgress(long current, long contentLength, int percent)`  L83 @Override
    - 体内字面量："\n" · "%"
- `void onFail(int code)`  L88 @Override
- `void onInterrupted()`  L97 @Override
- `Integer runThread()`  L103 @Override
    - 体内字面量："sendRtmp2Hisi" · "sendRtmp2Hisi stSendMsg"
- `void run()`  L174 @Override
    - 体内字面量："\n" · "%" · "sendRtmp2Hisi write data" · "sendRtmp2Hisi write data" · "last 10 bytes: " · "sendRtmp2Hisi FileInputStream" · "sendRtmp2Hisi md5"
- `void run_UIThread(Integer code)`  L218 @Override
- `String bytesToHex(byte[] bytes)`  L232
    - 体内字面量："%02X "
- `void dealSuccess()`  L241
- `Object runThread()`  L246 @Override
- `int closeSocket(int ret)`  L254
### `com.gku.SendSoftActivity$CallbackHisi`
L42 · [interface] private CallbackHisi · `com/gku/SendSoftActivity.java`

方法（3）：
- `void onFail(int code)`  L43
- `void onProgress(long current, long contentLength, int percent)`  L45
- `void onSuccess()`  L47