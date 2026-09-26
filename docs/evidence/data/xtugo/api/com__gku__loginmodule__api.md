# XTU GO — 类与成员明细：com.gku.loginmodule.api

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.api.ApiService`
L35 · [interface] public ApiService · `com/gku/loginmodule/api/ApiService.java`

方法（21）：
- `Observable<DeleteUserResponse> deleteUser(@Body RequestBody requestBodyMap)`  L37 @POST("v1/delete")
    - 体内字面量："v1/forgot_password"
- `Observable<ForgetPwdResponse> forgetPwd(@Body RequestBody requestBodyMap)`  L40 @POST("v1/forgot_password")
    - 体内字面量："api/getLanguages"
- `Observable<GetLanguagesResponse> getLanguages()`  L43 @POST("api/getLanguages")
    - 体内字面量："v1/push/api/getNewestVersion" · "firm_ware_model" · "region" · "hardware_version" · "v1/feedback/qs_type_options"
- `Observable<GetProblemTypesResponse> getProblemTypes()`  L49 @GET("v1/feedback/qs_type_options")
    - 体内字面量："v1/device_models"
- `Observable<GetProductTypesResponse> getProductTypes()`  L52 @GET("v1/device_models")
    - 体内字面量："api/promotions"
- `Observable<GetPromotionListResponse> getPromotionList(@PartMap Map<String, RequestBody> requestBodyMap)`  L56 @POST("api/promotions") @Multipart
    - 体内字面量："v1/login"
- `Observable<LoginResponse> login(@Body RequestBody requestBodyMap)`  L59 @POST("v1/login")
    - 体内字面量："v1/logout"
- `Observable<LogoutResponse> logout(@Body RequestBody requestBodyMap)`  L62 @POST("v1/logout")
    - 体内字面量："v1/modify_password"
- `Observable<ModifyPwdResponse> modifyPwd(@Body RequestBody requestBodyMap)`  L65 @POST("v1/modify_password")
    - 体内字面量："api/promotions"
- `Call<ResponseBody> postGetPromotionList()`  L68 @POST("api/promotions")
    - 体内字面量："api/promotions"
- `Call<JsonObject> postGetPromotionListJ()`  L71 @POST("api/promotions")
- `Call<ResponseBody> postGetVerifyCode(@Url String url, @PartMap Map<String, RequestBody> requestBodyMap)`  L75 @POST @Multipart
    - 体内字面量："api/sendCode"
- `Call<ResponseBody> postGetVerifyCode(@PartMap Map<String, RequestBody> requestBodyMap)`  L79 @POST("api/sendCode") @Multipart
    - 体内字面量："api/login"
- `Call<ResponseBody> postLogin(@PartMap Map<String, RequestBody> requestBodyMap)`  L83 @POST("api/login") @Multipart
- `Call<ResponseBody> postRegisterAccount(@Url String url, @PartMap Map<String, RequestBody> requestBodyMap)`  L87 @POST @Multipart
    - 体内字面量："api/regist"
- `Call<ResponseBody> postRegisterAccount(@PartMap Map<String, RequestBody> requestBodyMap)`  L91 @POST("api/regist") @Multipart
    - 体内字面量："api/upload" · "file\"; filename=\"uploadFile.zip" · "v1/register"
- `Observable<RegisterResponse> register(@Body RequestBody requestBodyMap)`  L98 @POST("v1/register")
    - 体内字面量："v1/feedback"
- `Observable<ReportFeedbackResponse> reportFeedback(@PartMap Map<String, RequestBody> requestBodyMap)`  L102 @POST("v1/feedback") @Multipart
    - 体内字面量："v1/users/profile"
- `Observable<UpdateUserInformationResponse> updateUserInformation(@Body RequestBody requestBody)`  L105 @POST("v1/users/profile")
    - 体内字面量："v1/upload/image"
- `Observable<UploadAttachmentResponse> uploadAttachment(@Part MultipartBody.Part file)`  L109 @POST("v1/upload/image") @Multipart
    - 体内字面量："v1/vcode"
- `Observable<VerifyCodeResponse> verifyCode(@Body RequestBody requestBodyMap)`  L112 @POST("v1/vcode")