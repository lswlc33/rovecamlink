# TUWIN — 原生库（lib/*.so）全量清点

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 9 个 .so；符号与字符串来自 ELF .dynsym / .rodata，直接反映 Java 层看不到的协议实现
> `JNI 导出` 数即该库为 Java 侧提供的 native 方法数量，明细见 `natives-symbols.tsv`

---

| 库 | 字节 | ELF | DT_NEEDED | 导出符号 | 导入符号 | JNI 导出 | 可读字符串 |
|---|---|---|---|---|---|---|---|
| lib/arm64-v8a/libdatastore_shared_counter.so | 7,112 | 64-bit AArch64 | libm.so libdl.so libc.so | 9 | 10 | 4 | 49 |
| lib/arm64-v8a/libffmpeg.so | 15,561,312 | 64-bit AArch64 | liblog.so libandroid.so libOpenSLES.so libEGL.so libGLESv2.so libjnigraphics.so libz.so libc.so libm.so libstdc++.so libdl.so | 6541 | 258 | 36 | 57146 |
| lib/arm64-v8a/libijkffmpeg.so | 6,440,880 | 64-bit AArch64 | libm.so libz.so libdl.so libc.so | 8809 | 200 | 0 | 32099 |
| lib/arm64-v8a/libijkplayer.so | 545,896 | 64-bit AArch64 | libijkffmpeg.so libijksdl.so liblog.so libandroid.so libdl.so libc.so libm.so | 826 | 364 | 0 | 2502 |
| lib/arm64-v8a/libijksdl.so | 362,832 | 64-bit AArch64 | libijkffmpeg.so liblog.so libandroid.so libOpenSLES.so libEGL.so libGLESv2.so libdl.so libc.so libm.so | 886 | 122 | 0 | 1735 |
| lib/arm64-v8a/libucrash-core.so | 101,376 | 64-bit AArch64 | liblog.so libdl.so libm.so libc.so | 0 | 66 | 0 | 411 |
| lib/arm64-v8a/libucrash.so | 51,288 | 64-bit AArch64 | liblog.so libdl.so libm.so libc.so | 1 | 97 | 0 | 247 |
| lib/arm64-v8a/libumeng-spy.so | 398,472 | 64-bit AArch64 | liblog.so libm.so libdl.so libc.so | 381 | 61 | 3 | 716 |
| lib/arm64-v8a/libumonitor.so | 250,968 | 64-bit AArch64 | liblog.so libm.so libdl.so libc.so | 1 | 88 | 0 | 651 |

## 库内协议相关字符串（分类计数）

| 分类 | 去重条数 | 含义 |
|---|---|---|
| url | 1 | 硬编码的 http(s) 端点 |
| rtsp | 1 | RTSP 拉流地址模板 |
| ip | 2 | 点分四元组常量 |
| httpPath | 16 | 查询串 |
| cgi | 0 | .cgi 路径 |
| filesystem | 9 | 文件系统路径 |
| socketApi | 9 | libc socket 系列导入 |
| protocolSymbol | 56 | 协议前缀符号（ptp/icatch/rtsp/h264/…） |
| mdnsDiscovery | 5 | mDNS/服务发现 |
| cryptoKey | 466 | 密钥/口令样式 |

## 逐条明细（最多每类每库 400 条，全量见 natives-strings.tsv）

### cryptoKey（505 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | #EXT-X-KEY:METHOD=AES-128,URI="%s" |
| lib/arm64-v8a/libffmpeg.so | 0123456789ABCDEFabcdef |
| lib/arm64-v8a/libffmpeg.so | 222222222222222222222222222222222222222222 |
| lib/arm64-v8a/libffmpeg.so | 666666666666666666666666 |
| lib/arm64-v8a/libffmpeg.so | 666666666666670766666666 |
| lib/arm64-v8a/libffmpeg.so | 77214d4b196a87cd520045fd20a51d67 |
| lib/arm64-v8a/libffmpeg.so | 77214d4b196a87cd520045fd2a51d673 |
| lib/arm64-v8a/libffmpeg.so | AES decryption initialization vector |
| lib/arm64-v8a/libffmpeg.so | AES decryption key |
| lib/arm64-v8a/libffmpeg.so | AES encryption initialization vector |
| lib/arm64-v8a/libffmpeg.so | AES encryption key |
| lib/arm64-v8a/libffmpeg.so | AES encryption/decryption initialization vector |
| lib/arm64-v8a/libffmpeg.so | AES encryption/decryption key |
| lib/arm64-v8a/libffmpeg.so | AES_CM_128_HMAC_SHA1_32 |
| lib/arm64-v8a/libffmpeg.so | AES_CM_128_HMAC_SHA1_80 |
| lib/arm64-v8a/libffmpeg.so | AES-128 |
| lib/arm64-v8a/libffmpeg.so | av_aes_alloc |
| lib/arm64-v8a/libffmpeg.so | av_aes_crypt |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_alloc |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_crypt |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_free |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_get_iv |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_increment_iv |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_init |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_set_full_iv |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_set_iv |
| lib/arm64-v8a/libffmpeg.so | av_aes_ctr_set_random_iv |
| lib/arm64-v8a/libffmpeg.so | av_aes_init |
| lib/arm64-v8a/libffmpeg.so | av_aes_size |
| lib/arm64-v8a/libffmpeg.so | Configures the encryption scheme, allowed values are none, cenc-aes-ctr |
| lib/arm64-v8a/libffmpeg.so | DDDDDDDDDDDDDDDD |
| lib/arm64-v8a/libffmpeg.so | DDDDDDDDDDDDDDDDDDDDD |
| lib/arm64-v8a/libffmpeg.so | DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD |
| lib/arm64-v8a/libffmpeg.so | DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD |
| lib/arm64-v8a/libffmpeg.so | enable AES128 encryption support |
| lib/arm64-v8a/libffmpeg.so | error reading D-10 aes3 frame |
| lib/arm64-v8a/libffmpeg.so | f4b6c29ca248858bb7177e64694e42a8 |
| lib/arm64-v8a/libffmpeg.so | ftp-anonymous-password |
| lib/arm64-v8a/libffmpeg.so | Incorrect username/password |
| lib/arm64-v8a/libffmpeg.so | Missing password for encrypted stream. Please use the -password option |
| lib/arm64-v8a/libffmpeg.so | nopassword |
| lib/arm64-v8a/libffmpeg.so | Overwriting -password <pass> with URI password! |
| lib/arm64-v8a/libffmpeg.so | password for anonymous login. E-mail address should be used. |
| lib/arm64-v8a/libffmpeg.so | Password-protected clip |
| lib/arm64-v8a/libffmpeg.so | SAMPLE-AES |
| lib/arm64-v8a/libffmpeg.so | SAMPLE-AES encryption is not supported yet |
| lib/arm64-v8a/libffmpeg.so | Secret bytes for Audible AAX files |
| lib/arm64-v8a/libffmpeg.so | Secret data: |
| lib/arm64-v8a/libffmpeg.so | Set decoding password |
| lib/arm64-v8a/libffmpeg.so | set password |
| lib/arm64-v8a/libffmpeg.so | SRTP_AES128_CM_HMAC_SHA1_32 |
| lib/arm64-v8a/libffmpeg.so | SRTP_AES128_CM_HMAC_SHA1_80 |
| lib/arm64-v8a/libijkffmpeg.so | _armv8_aes_probe |
| lib/arm64-v8a/libijkffmpeg.so | -----BEGIN |
| lib/arm64-v8a/libijkffmpeg.so | -----BEGIN %s----- |
| lib/arm64-v8a/libijkffmpeg.so | 0123456789abcdef |
| lib/arm64-v8a/libijkffmpeg.so | 0123456789ABCDEF |
| lib/arm64-v8a/libijkffmpeg.so | 77214d4b196a87cd520045fd20a51d67 |
| lib/arm64-v8a/libijkffmpeg.so | ADH-AES128-GCM-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | ADH-AES128-SHA |
| lib/arm64-v8a/libijkffmpeg.so | ADH-AES128-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | ADH-AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | ADH-AES256-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | AECDH-AES128-SHA |
| lib/arm64-v8a/libijkffmpeg.so | AES decryption initialization vector |
| lib/arm64-v8a/libijkffmpeg.so | AES encryption initialization vector |
| lib/arm64-v8a/libijkffmpeg.so | AES encryption/decryption initialization vector |
| lib/arm64-v8a/libijkffmpeg.so | AES encryption/decryption key |
| lib/arm64-v8a/libijkffmpeg.so | AES_cbc_encrypt |
| lib/arm64-v8a/libijkffmpeg.so | AES_CM_128_HMAC_SHA1_32 |
| lib/arm64-v8a/libijkffmpeg.so | AES_decrypt |
| lib/arm64-v8a/libijkffmpeg.so | AES_encrypt |
| lib/arm64-v8a/libijkffmpeg.so | aes_gcm_ctrl |
| lib/arm64-v8a/libijkffmpeg.so | aes_ocb_cipher |
| lib/arm64-v8a/libijkffmpeg.so | AES_set_decrypt_key |
| lib/arm64-v8a/libijkffmpeg.so | AES_set_encrypt_key |
| lib/arm64-v8a/libijkffmpeg.so | aes_t4_init_key |
| lib/arm64-v8a/libijkffmpeg.so | aes_t4_xts_init_key |
| lib/arm64-v8a/libijkffmpeg.so | AES_unwrap_key |
| lib/arm64-v8a/libijkffmpeg.so | aes_v8_cbc_encrypt |
| lib/arm64-v8a/libijkffmpeg.so | aes_v8_ctr32_encrypt_blocks |
| lib/arm64-v8a/libijkffmpeg.so | aes_v8_decrypt |
| lib/arm64-v8a/libijkffmpeg.so | aes_v8_encrypt |
| lib/arm64-v8a/libijkffmpeg.so | aes_v8_set_decrypt_key |
| lib/arm64-v8a/libijkffmpeg.so | aes_v8_set_encrypt_key |
| lib/arm64-v8a/libijkffmpeg.so | aes_wrap_cipher |
| lib/arm64-v8a/libijkffmpeg.so | AES_wrap_key |
| lib/arm64-v8a/libijkffmpeg.so | aes_xts_init_key |
| lib/arm64-v8a/libijkffmpeg.so | AES-128 |
| lib/arm64-v8a/libijkffmpeg.so | aes-128-cbc |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-CBC |
| lib/arm64-v8a/libijkffmpeg.so | aes-128-cbc-hmac-sha1 |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-CBC-HMAC-SHA1 |
| lib/arm64-v8a/libijkffmpeg.so | aes-128-cbc-hmac-sha256 |
| lib/arm64-v8a/libijkffmpeg.so | aes-128-ccm |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-CFB |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-CFB1 |
| lib/arm64-v8a/libijkffmpeg.so | aes-128-cfb8 |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-CFB8 |
| lib/arm64-v8a/libijkffmpeg.so | aes-128-ctr |
| lib/arm64-v8a/libijkffmpeg.so | aes-128-ecb |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-OCB |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-OFB |
| lib/arm64-v8a/libijkffmpeg.so | AES-128-XTS |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-cbc |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-CBC |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-CBC-HMAC-SHA1 |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-cbc-hmac-sha256 |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-CBC-HMAC-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-ccm |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-CFB |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-cfb1 |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-CFB1 |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-ctr |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-CTR |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-ecb |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-ECB |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-ocb |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-OCB |
| lib/arm64-v8a/libijkffmpeg.so | aes-192-ofb |
| lib/arm64-v8a/libijkffmpeg.so | AES-192-OFB |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-cbc |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-CBC |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-cbc-hmac-sha1 |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-CBC-HMAC-SHA1 |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-cbc-hmac-sha256 |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-CBC-HMAC-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-ccm |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-cfb |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-CFB |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-cfb1 |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-CFB1 |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-cfb8 |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-CFB8 |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-ctr |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-ecb |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-ECB |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-ocb |
| lib/arm64-v8a/libijkffmpeg.so | aes-256-ofb |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-OFB |
| lib/arm64-v8a/libijkffmpeg.so | AES-256-XTS |
| lib/arm64-v8a/libijkffmpeg.so | AES(256) |
| lib/arm64-v8a/libijkffmpeg.so | aes128 |
| lib/arm64-v8a/libijkffmpeg.so | AES128 |
| lib/arm64-v8a/libijkffmpeg.so | AES128-CCM |
| lib/arm64-v8a/libijkffmpeg.so | AES128-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | AES128-SHA |
| lib/arm64-v8a/libijkffmpeg.so | AES128-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | aes128-wrap |
| lib/arm64-v8a/libijkffmpeg.so | aes256 |
| lib/arm64-v8a/libijkffmpeg.so | AES256-CCM |
| lib/arm64-v8a/libijkffmpeg.so | AES256-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | AES256-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | aes256-wrap |
| lib/arm64-v8a/libijkffmpeg.so | AESCCM |
| lib/arm64-v8a/libijkffmpeg.so | AESCCM(128) |
| lib/arm64-v8a/libijkffmpeg.so | AESCCM(256) |
| lib/arm64-v8a/libijkffmpeg.so | AESCCM8 |
| lib/arm64-v8a/libijkffmpeg.so | AESCCM8(128) |
| lib/arm64-v8a/libijkffmpeg.so | AESGCM |
| lib/arm64-v8a/libijkffmpeg.so | AESGCM(256) |
| lib/arm64-v8a/libijkffmpeg.so | aesni_init_key |
| lib/arm64-v8a/libijkffmpeg.so | aesni_xts_init_key |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_alloc |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_crypt |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_alloc |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_crypt |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_free |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_get_iv |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_increment_iv |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_init |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_set_full_iv |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_set_iv |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_ctr_set_random_iv |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_init |
| lib/arm64-v8a/libijkffmpeg.so | av_aes_size |
| lib/arm64-v8a/libijkffmpeg.so | bad password read |
| lib/arm64-v8a/libijkffmpeg.so | cenc-aes-ctr |
| lib/arm64-v8a/libijkffmpeg.so | challengePassword |
| lib/arm64-v8a/libijkffmpeg.so | CLIENT_EARLY_TRAFFIC_SECRET |
| lib/arm64-v8a/libijkffmpeg.so | CLIENT_HANDSHAKE_TRAFFIC_SECRET |
| lib/arm64-v8a/libijkffmpeg.so | CLIENT_TRAFFIC_SECRET_0 |
| lib/arm64-v8a/libijkffmpeg.so | CMS_add0_recipient_password |
| lib/arm64-v8a/libijkffmpeg.so | CMS_decrypt_set1_password |
| lib/arm64-v8a/libijkffmpeg.so | CMS_PasswordRecipientInfo_it |
| lib/arm64-v8a/libijkffmpeg.so | CMS_RecipientInfo_set0_password |
| lib/arm64-v8a/libijkffmpeg.so | Configures the encryption scheme, allowed values are none, cenc-aes-ctr |
| lib/arm64-v8a/libijkffmpeg.so | curve448_base_double_scalarmul_non_secret |
| lib/arm64-v8a/libijkffmpeg.so | DHE-DSS-AES128-GCM-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-DSS-AES128-SHA |
| lib/arm64-v8a/libijkffmpeg.so | DHE-DSS-AES128-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-DSS-AES256-SHA |
| lib/arm64-v8a/libijkffmpeg.so | DHE-DSS-AES256-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES128-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES128-CBC-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES128-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES128-GCM-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES256-CBC-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES256-CCM |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES256-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-PSK-AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES128-CCM |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES128-GCM-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES128-SHA |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES128-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES256-CCM |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES256-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | DHE-RSA-AES256-SHA |
| lib/arm64-v8a/libijkffmpeg.so | EARLY_EXPORTER_SECRET |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-ECDSA-AES128-GCM-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-ECDSA-AES128-SHA |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-ECDSA-AES128-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-ECDSA-AES256-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-ECDSA-AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-ECDSA-AES256-SHA |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-PSK-AES128-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-PSK-AES128-CBC-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-PSK-AES256-CBC-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-RSA-AES256-SHA |
| lib/arm64-v8a/libijkffmpeg.so | ECDHE-RSA-AES256-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_cbc |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_cbc_hmac_sha1 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_cbc_hmac_sha256 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_ccm |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_cfb1 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_cfb128 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_cfb8 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_ctr |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_ecb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_gcm |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_ocb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_ofb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_wrap |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_wrap_pad |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_128_xts |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_cbc |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_ccm |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_cfb1 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_cfb128 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_cfb8 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_ctr |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_ecb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_gcm |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_ocb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_ofb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_wrap |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_192_wrap_pad |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_cbc |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_cbc_hmac_sha1 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_cbc_hmac_sha256 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_ccm |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_cfb1 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_cfb128 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_cfb8 |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_ctr |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_ecb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_gcm |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_ocb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_ofb |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_wrap |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_wrap_pad |
| lib/arm64-v8a/libijkffmpeg.so | EVP_aes_256_xts |
| lib/arm64-v8a/libijkffmpeg.so | EXPORTER_SECRET |
| lib/arm64-v8a/libijkffmpeg.so | extended master secret |
| lib/arm64-v8a/libijkffmpeg.so | ftp-anonymous-password |
| lib/arm64-v8a/libijkffmpeg.so | id-aes128-wrap-pad |
| lib/arm64-v8a/libijkffmpeg.so | id-aes192-CCM |
| lib/arm64-v8a/libijkffmpeg.so | id-aes192-GCM |
| lib/arm64-v8a/libijkffmpeg.so | id-aes192-wrap-pad |
| lib/arm64-v8a/libijkffmpeg.so | id-aes256-GCM |
| lib/arm64-v8a/libijkffmpeg.so | id-aes256-wrap |
| lib/arm64-v8a/libijkffmpeg.so | missing secret |
| lib/arm64-v8a/libijkffmpeg.so | no password |
| lib/arm64-v8a/libijkffmpeg.so | nopassword |
| lib/arm64-v8a/libijkffmpeg.so | password based MAC |
| lib/arm64-v8a/libijkffmpeg.so | password for anonymous login. E-mail address should be used. |
| lib/arm64-v8a/libijkffmpeg.so | PKCS12 import password |
| lib/arm64-v8a/libijkffmpeg.so | PKCS8 decrypt password |
| lib/arm64-v8a/libijkffmpeg.so | problems getting password |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES128-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES128-CBC-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES128-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES128-GCM-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES256-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES256-CBC-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES256-CCM |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES256-CCM8 |
| lib/arm64-v8a/libijkffmpeg.so | PSK-AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | RSA-PSK-AES128-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | RSA-PSK-AES128-GCM-SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | RSA-PSK-AES256-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | RSA-PSK-AES256-GCM-SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | RSAES-OAEP |
| lib/arm64-v8a/libijkffmpeg.so | rsaesOaep |
| lib/arm64-v8a/libijkffmpeg.so | s390x_aes_gcm_ctrl |
| lib/arm64-v8a/libijkffmpeg.so | SAMPLE-AES |
| lib/arm64-v8a/libijkffmpeg.so | secret |
| lib/arm64-v8a/libijkffmpeg.so | Secret bytes for Audible AAX files |
| lib/arm64-v8a/libijkffmpeg.so | Secret data: |
| lib/arm64-v8a/libijkffmpeg.so | secretBag |
| lib/arm64-v8a/libijkffmpeg.so | SERVER_TRAFFIC_SECRET_0 |
| lib/arm64-v8a/libijkffmpeg.so | srp_generate_client_master_secret |
| lib/arm64-v8a/libijkffmpeg.so | srp_generate_server_master_secret |
| lib/arm64-v8a/libijkffmpeg.so | SRP-AES-128-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | SRP-AES-256-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | SRP-DSS-AES-256-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | SRP-RSA-AES-128-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | SRP-RSA-AES-256-CBC-SHA |
| lib/arm64-v8a/libijkffmpeg.so | SRTP_AEAD_AES_256_GCM |
| lib/arm64-v8a/libijkffmpeg.so | SRTP_AES128_CM_HMAC_SHA1_32 |
| lib/arm64-v8a/libijkffmpeg.so | SRTP_AES128_CM_HMAC_SHA1_80 |
| lib/arm64-v8a/libijkffmpeg.so | SRTP_AES128_CM_SHA1_32 |
| lib/arm64-v8a/libijkffmpeg.so | SRTP_AES128_CM_SHA1_80 |
| lib/arm64-v8a/libijkffmpeg.so | SSL_CTX_set_srp_password |
| lib/arm64-v8a/libijkffmpeg.so | ssl_generate_master_secret |
| lib/arm64-v8a/libijkffmpeg.so | ssl_log_secret |
| lib/arm64-v8a/libijkffmpeg.so | SSL_set_session_secret_cb |
| lib/arm64-v8a/libijkffmpeg.so | ssl3_generate_master_secret |
| lib/arm64-v8a/libijkffmpeg.so | TLS_AES_128_CCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DH_anon_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DH_anon_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DH_anon_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DH_anon_WITH_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DH_anon_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_DSS_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_DSS_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_PSK_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_PSK_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_PSK_WITH_AES_128_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_PSK_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_PSK_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_PSK_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_PSK_WITH_AES_256_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_RSA_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_RSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_RSA_WITH_AES_256_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDH_anon_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_128_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_256_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_DHE_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_128_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_256_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_PSK_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_PSK_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_PSK_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_PSK_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_PSK_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_WITH_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_WITH_AES_256_CCM |
| lib/arm64-v8a/libijkffmpeg.so | TLS_RSA_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libijkffmpeg.so | TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_SRP_SHA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | TLS_SRP_SHA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libijkffmpeg.so | tls1_generate_master_secret |
| lib/arm64-v8a/libijkffmpeg.so | tls13_generate_handshake_secret |
| lib/arm64-v8a/libijkffmpeg.so | tls13_generate_master_secret |
| lib/arm64-v8a/libijkffmpeg.so | tls13_generate_secret |
| lib/arm64-v8a/libijkffmpeg.so | vpaes_cbc_encrypt |
| lib/arm64-v8a/libijkffmpeg.so | vpaes_decrypt |
| lib/arm64-v8a/libijkffmpeg.so | vpaes_ecb_decrypt |
| lib/arm64-v8a/libijkffmpeg.so | vpaes_ecb_encrypt |
| lib/arm64-v8a/libijkffmpeg.so | vpaes_encrypt |
| lib/arm64-v8a/libijkffmpeg.so | vpaes_set_decrypt_key |
| lib/arm64-v8a/libijkffmpeg.so | vpaes_set_encrypt_key |

_其余 105 条见 natives-strings.tsv_

### filesystem（15 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | /tmp/%sXXXXXX |
| lib/arm64-v8a/libijkffmpeg.so | /tmp/%sXXXXXX |
| lib/arm64-v8a/libucrash-core.so | /proc/%d/cmdline |
| lib/arm64-v8a/libucrash-core.so | /proc/%d/comm |
| lib/arm64-v8a/libucrash-core.so | /proc/%d/maps |
| lib/arm64-v8a/libucrash-core.so | /proc/%d/task |
| lib/arm64-v8a/libucrash.so | /data/ |
| lib/arm64-v8a/libucrash.so | /data/anr/traces.txt |
| lib/arm64-v8a/libucrash.so | /proc/%d/cmdline |
| lib/arm64-v8a/libucrash.so | /proc/%d/comm |
| lib/arm64-v8a/libucrash.so | /proc/%d/maps |
| lib/arm64-v8a/libucrash.so | /proc/%d/status |
| lib/arm64-v8a/libucrash.so | /proc/%d/task |
| lib/arm64-v8a/libucrash.so | /proc/self/maps |
| lib/arm64-v8a/libumonitor.so | /proc/self/maps |

### httpPath（29 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | ?authmod=%s&user=%s |
| lib/arm64-v8a/libffmpeg.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/arm64-v8a/libffmpeg.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/arm64-v8a/libffmpeg.so | ?connect=1 |
| lib/arm64-v8a/libffmpeg.so | ?localport=%d |
| lib/arm64-v8a/libffmpeg.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/arm64-v8a/libffmpeg.so | ?m=)T\|= |
| lib/arm64-v8a/libffmpeg.so | ?reason=authfailed |
| lib/arm64-v8a/libffmpeg.so | ?reason=needauth |
| lib/arm64-v8a/libffmpeg.so | ?reason=nosuchuser |
| lib/arm64-v8a/libffmpeg.so | ?timeout=%d |
| lib/arm64-v8a/libffmpeg.so | ?ttl=%d |
| lib/arm64-v8a/libffmpeg.so | ?ttl=%d&connect=1 |
| lib/arm64-v8a/libffmpeg.so | ?u='@ |
| lib/arm64-v8a/libijkffmpeg.so | ?authmod=%s&user=%s |
| lib/arm64-v8a/libijkffmpeg.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/arm64-v8a/libijkffmpeg.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/arm64-v8a/libijkffmpeg.so | ?connect=1 |
| lib/arm64-v8a/libijkffmpeg.so | ?listen=1 |
| lib/arm64-v8a/libijkffmpeg.so | ?localport=%d |
| lib/arm64-v8a/libijkffmpeg.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/arm64-v8a/libijkffmpeg.so | ?m=)T\|= |
| lib/arm64-v8a/libijkffmpeg.so | ?reason=authfailed |
| lib/arm64-v8a/libijkffmpeg.so | ?reason=needauth |
| lib/arm64-v8a/libijkffmpeg.so | ?reason=nosuchuser |
| lib/arm64-v8a/libijkffmpeg.so | ?timeout=%d |
| lib/arm64-v8a/libijkffmpeg.so | ?ttl=%d |
| lib/arm64-v8a/libijkffmpeg.so | ?u='@ |
| lib/arm64-v8a/libijkffmpeg.so | ?y=x?y<x?y5x?i(x |

### ip（2 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | 127.0.0.1 |
| lib/arm64-v8a/libffmpeg.so | 224.2.127.254 |

### jpegExif（2 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/arm64-v8a/libffmpeg.so | IFD offset is greater than image size |

### mdnsDiscovery（6 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_cleanup_local |
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_get_local |
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_init_local |
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_set_local |
| lib/arm64-v8a/libucrash-core.so | _Uaarch64_init_local |
| lib/arm64-v8a/libucrash.so | _Uaarch64_init_local |

### protocolSymbol（91 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | aac bitstream error |
| lib/arm64-v8a/libffmpeg.so | aac_adtstoasc |
| lib/arm64-v8a/libffmpeg.so | aac_coder |
| lib/arm64-v8a/libffmpeg.so | aac_eld |
| lib/arm64-v8a/libffmpeg.so | aac_he_v2 |
| lib/arm64-v8a/libffmpeg.so | aac_is |
| lib/arm64-v8a/libffmpeg.so | aac_latm |
| lib/arm64-v8a/libffmpeg.so | aac_ld |
| lib/arm64-v8a/libffmpeg.so | aac_ltp |
| lib/arm64-v8a/libffmpeg.so | aac_main |
| lib/arm64-v8a/libffmpeg.so | aac_ms |
| lib/arm64-v8a/libffmpeg.so | aac_pce |
| lib/arm64-v8a/libffmpeg.so | aac_pns |
| lib/arm64-v8a/libffmpeg.so | aac_pred |
| lib/arm64-v8a/libffmpeg.so | aac_seq_header_detect |
| lib/arm64-v8a/libffmpeg.so | aac_ssr |
| lib/arm64-v8a/libffmpeg.so | aac_tns |
| lib/arm64-v8a/libffmpeg.so | aac,adts |
| lib/arm64-v8a/libffmpeg.so | h264 demuxer |
| lib/arm64-v8a/libffmpeg.so | h264 profile |
| lib/arm64-v8a/libffmpeg.so | h264 profile not found |
| lib/arm64-v8a/libffmpeg.so | h264_mediacodec |
| lib/arm64-v8a/libffmpeg.so | h264_metadata |
| lib/arm64-v8a/libffmpeg.so | h264_metadata_bsf |
| lib/arm64-v8a/libffmpeg.so | h264_mode0 |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb bitstream filter required for H.264 streams |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb filter failed to receive output packet |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb filter failed to send input packet |
| lib/arm64-v8a/libffmpeg.so | h264_redundant_pps |
| lib/arm64-v8a/libffmpeg.so | h264_slice_header_init() failed |
| lib/arm64-v8a/libffmpeg.so | h264_v4l2_m2m_decoder |
| lib/arm64-v8a/libffmpeg.so | h264_v4l2_m2m_encoder |
| lib/arm64-v8a/libffmpeg.so | h264_v4l2m2m |
| lib/arm64-v8a/libffmpeg.so | h264,264 |
| lib/arm64-v8a/libffmpeg.so | rtp_flags |
| lib/arm64-v8a/libffmpeg.so | rtp_mpegts |
| lib/arm64-v8a/libffmpeg.so | rtp_resolve_host: %s |
| lib/arm64-v8a/libffmpeg.so | rtp_send_data size=%d |
| lib/arm64-v8a/libffmpeg.so | rtpflags |
| lib/arm64-v8a/libffmpeg.so | rtphint |
| lib/arm64-v8a/libffmpeg.so | rtpmap: |
| lib/arm64-v8a/libffmpeg.so | rtpqmotv_bTR_^} |
| lib/arm64-v8a/libffmpeg.so | rtptime |
| lib/arm64-v8a/libffmpeg.so | rtsp_flags |
| lib/arm64-v8a/libffmpeg.so | rtsp_transport |
| lib/arm64-v8a/libffmpeg.so | rtsp: |
| lib/arm64-v8a/libffmpeg.so | rtsp:// |
| lib/arm64-v8a/libffmpeg.so | rtsps |
| lib/arm64-v8a/libffmpeg.so | socket option UDPLITE_RECV_CSCOV not available |
| lib/arm64-v8a/libffmpeg.so | socket option UDPLITE_SEND_CSCOV not available |
| lib/arm64-v8a/libffmpeg.so | sscanf |
| lib/arm64-v8a/libijkffmpeg.so | aac bitstream error |
| lib/arm64-v8a/libijkffmpeg.so | aac_adtstoasc |
| lib/arm64-v8a/libijkffmpeg.so | aac_eld |
| lib/arm64-v8a/libijkffmpeg.so | aac_he |
| lib/arm64-v8a/libijkffmpeg.so | aac_he_v2 |
| lib/arm64-v8a/libijkffmpeg.so | aac_latm |
| lib/arm64-v8a/libijkffmpeg.so | aac_ld |
| lib/arm64-v8a/libijkffmpeg.so | aac_low |
| lib/arm64-v8a/libijkffmpeg.so | aac_ltp |
| lib/arm64-v8a/libijkffmpeg.so | aac_main |
| lib/arm64-v8a/libijkffmpeg.so | aac_ssr |
| lib/arm64-v8a/libijkffmpeg.so | h264_metadata |
| lib/arm64-v8a/libijkffmpeg.so | h264_metadata_bsf |
| lib/arm64-v8a/libijkffmpeg.so | h264_mode0 |
| lib/arm64-v8a/libijkffmpeg.so | h264_mp4toannexb |
| lib/arm64-v8a/libijkffmpeg.so | h264_mp4toannexb bitstream filter required for H.264 streams |
| lib/arm64-v8a/libijkffmpeg.so | h264_mp4toannexb filter failed to receive output packet |
| lib/arm64-v8a/libijkffmpeg.so | h264_mp4toannexb filter failed to send input packet |
| lib/arm64-v8a/libijkffmpeg.so | h264_redundant_pps |
| lib/arm64-v8a/libijkffmpeg.so | h264_slice_header_init() failed |
| lib/arm64-v8a/libijkffmpeg.so | rtp_flags |
| lib/arm64-v8a/libijkffmpeg.so | rtpflags |
| lib/arm64-v8a/libijkffmpeg.so | rtphint |
| lib/arm64-v8a/libijkffmpeg.so | rtpmap: |
| lib/arm64-v8a/libijkffmpeg.so | rtptime |
| lib/arm64-v8a/libijkffmpeg.so | rtsp_flags |
| lib/arm64-v8a/libijkffmpeg.so | rtsp_transport |
| lib/arm64-v8a/libijkffmpeg.so | rtsp: |
| lib/arm64-v8a/libijkffmpeg.so | rtsp:// |
| lib/arm64-v8a/libijkffmpeg.so | rtsps |
| lib/arm64-v8a/libijkffmpeg.so | rtsps: |
| lib/arm64-v8a/libijkffmpeg.so | socket |
| lib/arm64-v8a/libijkffmpeg.so | socket option UDPLITE_RECV_CSCOV not available |
| lib/arm64-v8a/libijkffmpeg.so | socket option UDPLITE_SEND_CSCOV not available |
| lib/arm64-v8a/libijkffmpeg.so | sscanf |
| lib/arm64-v8a/libijkplayer.so | sscanf |
| lib/arm64-v8a/libucrash-core.so | sscanf |
| lib/arm64-v8a/libucrash.so | sscanf |
| lib/arm64-v8a/libumonitor.so | sscanf |

### rtsp（2 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | rtsp:// |
| lib/arm64-v8a/libijkffmpeg.so | rtsp:// |

### socketApi（15 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | getsockname |
| lib/arm64-v8a/libffmpeg.so | recvfrom |
| lib/arm64-v8a/libffmpeg.so | sendto |
| lib/arm64-v8a/libffmpeg.so | setsockopt |
| lib/arm64-v8a/libijkffmpeg.so | accept |
| lib/arm64-v8a/libijkffmpeg.so | connect |
| lib/arm64-v8a/libijkffmpeg.so | getsockname |
| lib/arm64-v8a/libijkffmpeg.so | inet_ntop |
| lib/arm64-v8a/libijkffmpeg.so | listen |
| lib/arm64-v8a/libijkffmpeg.so | recvfrom |
| lib/arm64-v8a/libijkffmpeg.so | sendto |
| lib/arm64-v8a/libijkffmpeg.so | setsockopt |
| lib/arm64-v8a/libijkffmpeg.so | socket |
| lib/arm64-v8a/libucrash.so | connect |
| lib/arm64-v8a/libumonitor.so | connect |

### url（2 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libffmpeg.so | http:// |
| lib/arm64-v8a/libijkffmpeg.so | http:// |
