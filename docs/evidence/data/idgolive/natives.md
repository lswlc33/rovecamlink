# idGoLive — 原生库（lib/*.so）全量清点

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 63 个 .so；符号与字符串来自 ELF .dynsym / .rodata，直接反映 Java 层看不到的协议实现
> `JNI 导出` 数即该库为 Java 侧提供的 native 方法数量，明细见 `natives-symbols.tsv`

---

| 库 | 字节 | ELF | DT_NEEDED | 导出符号 | 导入符号 | JNI 导出 | 可读字符串 |
|---|---|---|---|---|---|---|---|
| lib/arm64-v8a/libPhoenix_libCodec.so | 1,047,416 | 64-bit AArch64 | libffmpeg.so libm.so libc.so libdl.so | 1348 | 128 | 6 | 2357 |
| lib/arm64-v8a/libavcodec.so | 12,633,600 | 64-bit AArch64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libswresample.so libavutil.so | 159 | 414 | 0 | 41977 |
| lib/arm64-v8a/libavdevice.so | 51,120 | 64-bit AArch64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavfilter.so libavformat.so libavcodec.so libavutil.so | 15 | 153 | 0 | 444 |
| lib/arm64-v8a/libavfilter.so | 4,579,576 | 64-bit AArch64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libswscale.so libavformat.so libavcodec.so libswresample.so libavutil.so | 64 | 510 | 0 | 15184 |
| lib/arm64-v8a/libavformat.so | 4,885,952 | 64-bit AArch64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavcodec.so libavutil.so | 155 | 513 | 0 | 20968 |
| lib/arm64-v8a/libavutil.so | 453,928 | 64-bit AArch64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so | 589 | 99 | 0 | 1952 |
| lib/arm64-v8a/libc++_shared.so | 6,835,688 | 64-bit AArch64 | libc.so libdl.so | 2239 | 128 | 0 | 29004 |
| lib/arm64-v8a/libcontrol.so | 919,176 | 64-bit AArch64 | libusb_transport.so liblog.so libz.so libreliant.so libc++_shared.so libm.so libdl.so libc.so | 2081 | 228 | 160 | 3948 |
| lib/arm64-v8a/libdepth_net_transport.so | 125,952 | 64-bit AArch64 | liblog.so libandroid.so libOpenSLES.so libc++_shared.so libm.so libdl.so libc.so | 281 | 99 | 5 | 531 |
| lib/arm64-v8a/libffmpeg.so | 15,826,848 | 64-bit AArch64 | libc.so libm.so libz.so libdl.so liblog.so | 6043 | 182 | 0 | 53463 |
| lib/arm64-v8a/libffmpegkit.so | 470,704 | 64-bit AArch64 | libavfilter.so libavformat.so libavcodec.so libavutil.so libswresample.so libavdevice.so libswscale.so libc++_shared.so liblog.so libz.so libandroid.so libc.so libm.so libdl.so | 401 | 442 | 14 | 2708 |
| lib/arm64-v8a/libffmpegkit_abidetect.so | 30,496 | 64-bit AArch64 | liblog.so libz.so libandroid.so libc.so libm.so libdl.so | 37 | 14 | 4 | 140 |
| lib/arm64-v8a/libijkffmpeg.so | 6,592,360 | 64-bit AArch64 | libm.so libz.so libdl.so libc.so | 8937 | 204 | 0 | 32527 |
| lib/arm64-v8a/libijkplayer.so | 545,832 | 64-bit AArch64 | libijkffmpeg.so libijksdl.so liblog.so libandroid.so libdl.so libc.so libm.so | 826 | 364 | 0 | 2501 |
| lib/arm64-v8a/libijksdl.so | 362,832 | 64-bit AArch64 | libijkffmpeg.so liblog.so libandroid.so libOpenSLES.so libEGL.so libGLESv2.so libdl.so libc.so libm.so | 886 | 122 | 0 | 1735 |
| lib/arm64-v8a/libpanorama_vr.so | 16,016,864 | 64-bit AArch64 | libusb_transport.so libdepth_net_transport.so libz.so libm.so libdl.so liblog.so libandroid.so libGLESv2.so libEGL.so libreliant.so libc++_shared.so libc.so | 17435 | 632 | 105 | 68574 |
| lib/arm64-v8a/libreliant.so | 337,880 | 64-bit AArch64 | libusb_transport.so libdepth_net_transport.so libc++_shared.so libm.so libdl.so libc.so | 957 | 82 | 0 | 1347 |
| lib/arm64-v8a/libswresample.so | 196,312 | 64-bit AArch64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavutil.so | 25 | 57 | 0 | 499 |
| lib/arm64-v8a/libswscale.so | 274,512 | 64-bit AArch64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavutil.so | 32 | 42 | 0 | 1434 |
| lib/arm64-v8a/libusb_transport.so | 830,768 | 64-bit AArch64 | liblog.so libandroid.so libOpenSLES.so libc++_shared.so libm.so libdl.so libc.so | 1797 | 166 | 31 | 3511 |
| lib/armeabi-v7a/libPhoenix_libCodec.so | 817,032 | 32-bit ARM |  | 0 | 0 | 0 | 2180 |
| lib/armeabi-v7a/libavcodec_neon.so | 13,709,804 | 32-bit ARM |  | 0 | 0 | 0 | 30582 |
| lib/armeabi-v7a/libavdevice_neon.so | 50,036 | 32-bit ARM |  | 0 | 0 | 0 | 449 |
| lib/armeabi-v7a/libavfilter_neon.so | 4,471,592 | 32-bit ARM |  | 0 | 0 | 0 | 10867 |
| lib/armeabi-v7a/libavformat_neon.so | 5,008,376 | 32-bit ARM |  | 0 | 0 | 0 | 20030 |
| lib/armeabi-v7a/libavutil_neon.so | 416,404 | 32-bit ARM |  | 0 | 0 | 0 | 1738 |
| lib/armeabi-v7a/libc++_shared.so | 7,126,916 | 32-bit ARM |  | 0 | 0 | 0 | 33068 |
| lib/armeabi-v7a/libcontrol.so | 845,428 | 32-bit ARM |  | 0 | 0 | 0 | 3836 |
| lib/armeabi-v7a/libdepth_net_transport.so | 105,224 | 32-bit ARM |  | 0 | 0 | 0 | 573 |
| lib/armeabi-v7a/libffmpeg.so | 16,611,616 | 32-bit ARM |  | 0 | 0 | 0 | 39746 |
| lib/armeabi-v7a/libffmpegkit_abidetect.so | 16,436 | 32-bit ARM |  | 0 | 0 | 0 | 164 |
| lib/armeabi-v7a/libffmpegkit_armv7a_neon.so | 493,552 | 32-bit ARM |  | 0 | 0 | 0 | 2736 |
| lib/armeabi-v7a/libijkffmpeg.so | 3,366,804 | 32-bit ARM |  | 0 | 0 | 0 | 24805 |
| lib/armeabi-v7a/libijkplayer.so | 362,580 | 32-bit ARM |  | 0 | 0 | 0 | 4162 |
| lib/armeabi-v7a/libijksdl.so | 311,820 | 32-bit ARM |  | 0 | 0 | 0 | 2797 |
| lib/armeabi-v7a/libpanorama_vr.so | 16,322,384 | 32-bit ARM |  | 0 | 0 | 0 | 59206 |
| lib/armeabi-v7a/libreliant.so | 302,808 | 32-bit ARM |  | 0 | 0 | 0 | 1279 |
| lib/armeabi-v7a/libswresample_neon.so | 223,892 | 32-bit ARM |  | 0 | 0 | 0 | 385 |
| lib/armeabi-v7a/libswscale_neon.so | 314,220 | 32-bit ARM |  | 0 | 0 | 0 | 278 |
| lib/armeabi-v7a/libusb_transport.so | 781,496 | 32-bit ARM |  | 0 | 0 | 0 | 3434 |
| lib/x86/libavcodec.so | 14,004,984 | 32-bit x86 |  | 0 | 0 | 0 | 54313 |
| lib/x86/libavdevice.so | 45,640 | 32-bit x86 |  | 0 | 0 | 0 | 497 |
| lib/x86/libavfilter.so | 5,182,392 | 32-bit x86 |  | 0 | 0 | 0 | 21801 |
| lib/x86/libavformat.so | 4,768,712 | 32-bit x86 |  | 0 | 0 | 0 | 26861 |
| lib/x86/libavutil.so | 424,884 | 32-bit x86 |  | 0 | 0 | 0 | 2410 |
| lib/x86/libc++_shared.so | 983,744 | 32-bit x86 |  | 0 | 0 | 0 | 3969 |
| lib/x86/libffmpegkit.so | 567,796 | 32-bit x86 |  | 0 | 0 | 0 | 3241 |
| lib/x86/libffmpegkit_abidetect.so | 43,976 | 32-bit x86 |  | 0 | 0 | 0 | 238 |
| lib/x86/libijkffmpeg.so | 6,683,356 | 32-bit x86 |  | 0 | 0 | 0 | 31758 |
| lib/x86/libijkplayer.so | 458,064 | 32-bit x86 |  | 0 | 0 | 0 | 2560 |
| lib/x86/libijksdl.so | 625,480 | 32-bit x86 |  | 0 | 0 | 0 | 2747 |
| lib/x86/libswresample.so | 271,332 | 32-bit x86 |  | 0 | 0 | 0 | 775 |
| lib/x86/libswscale.so | 313,436 | 32-bit x86 |  | 0 | 0 | 0 | 968 |
| lib/x86_64/libavcodec.so | 16,800,848 | 64-bit x86_64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libswresample.so libavutil.so | 159 | 417 | 0 | 72160 |
| lib/x86_64/libavdevice.so | 56,544 | 64-bit x86_64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavfilter.so libavformat.so libavcodec.so libavutil.so | 15 | 153 | 0 | 519 |
| lib/x86_64/libavfilter.so | 5,896,096 | 64-bit x86_64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libswscale.so libavformat.so libavcodec.so libswresample.so libavutil.so | 64 | 517 | 0 | 31059 |
| lib/x86_64/libavformat.so | 5,548,768 | 64-bit x86_64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavcodec.so libavutil.so | 155 | 513 | 0 | 32189 |
| lib/x86_64/libavutil.so | 647,560 | 64-bit x86_64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so | 589 | 100 | 0 | 3521 |
| lib/x86_64/libc++_shared.so | 1,039,104 | 64-bit x86_64 | libc.so libdl.so | 2270 | 158 | 0 | 5835 |
| lib/x86_64/libffmpegkit.so | 495,424 | 64-bit x86_64 | libavfilter.so libavformat.so libavcodec.so libavutil.so libswresample.so libavdevice.so libswscale.so libc++_shared.so liblog.so libz.so libandroid.so libc.so libm.so libdl.so | 401 | 444 | 14 | 4447 |
| lib/x86_64/libffmpegkit_abidetect.so | 47,104 | 64-bit x86_64 | liblog.so libz.so libandroid.so libc.so libm.so libdl.so | 39 | 14 | 4 | 246 |
| lib/x86_64/libswresample.so | 336,888 | 64-bit x86_64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavutil.so | 25 | 57 | 0 | 1139 |
| lib/x86_64/libswscale.so | 518,448 | 64-bit x86_64 | libc.so libm.so libdl.so liblog.so libandroid.so libcamera2ndk.so libmediandk.so libz.so libc++_shared.so libavutil.so | 32 | 44 | 0 | 1860 |

## 库内协议相关字符串（分类计数）

| 分类 | 去重条数 | 含义 |
|---|---|---|
| url | 19 | 硬编码的 http(s) 端点 |
| rtsp | 1 | RTSP 拉流地址模板 |
| ip | 41 | 点分四元组常量 |
| httpPath | 23 | 查询串 |
| cgi | 0 | .cgi 路径 |
| filesystem | 20 | 文件系统路径 |
| socketApi | 10 | libc socket 系列导入 |
| protocolSymbol | 331 | 协议前缀符号（ptp/icatch/rtsp/h264/…） |
| mdnsDiscovery | 6 | mDNS/服务发现 |
| cryptoKey | 819 | 密钥/口令样式 |

## 逐条明细（最多每类每库 400 条，全量见 natives-strings.tsv）

### cryptoKey（3106 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavcodec.so | Missing password for encrypted stream. Please use the -password option |
| lib/arm64-v8a/libavcodec.so | password |
| lib/arm64-v8a/libavcodec.so | Password-protected clip |
| lib/arm64-v8a/libavcodec.so | Set decoding password |
| lib/arm64-v8a/libavcodec.so | sveaes |
| lib/arm64-v8a/libavfilter.so | 0123456789abcdef |
| lib/arm64-v8a/libavfilter.so | 0123456789ABCDEF |
| lib/arm64-v8a/libavfilter.so | AEsmall |
| lib/arm64-v8a/libavfilter.so | FFFFFFFFFFFFFFFF |
| lib/arm64-v8a/libavfilter.so | FFFFFFFFFFFFFFFFFFFFFFFFFFFF |
| lib/arm64-v8a/libavfilter.so | password |
| lib/arm64-v8a/libavformat.so | _gnutls_call_secret_func |
| lib/arm64-v8a/libavformat.so | _gnutls_dh_set_secret_bits |
| lib/arm64-v8a/libavformat.so | _gnutls_ext_master_secret_recv_params |
| lib/arm64-v8a/libavformat.so | _gnutls_generate_early_secrets_for_psk |
| lib/arm64-v8a/libavformat.so | _tls13_derive_secret |
| lib/arm64-v8a/libavformat.so | _tls13_derive_secret2 |
| lib/arm64-v8a/libavformat.so | _tls13_expand_secret |
| lib/arm64-v8a/libavformat.so | _tls13_expand_secret2 |
| lib/arm64-v8a/libavformat.so | _tls13_init_secret2 |
| lib/arm64-v8a/libavformat.so | -----BEGIN |
| lib/arm64-v8a/libavformat.so | -----BEGIN CERTIFICATE |
| lib/arm64-v8a/libavformat.so | -----BEGIN X509 CERTIFICATE |
| lib/arm64-v8a/libavformat.so | -----BEGIN X509 CRL |
| lib/arm64-v8a/libavformat.so | !(length % AES_BLOCK_SIZE) |
| lib/arm64-v8a/libavformat.so | ./../x86/aes-gcm-aead.h |
| lib/arm64-v8a/libavformat.so | ./aes-aarch64.h |
| lib/arm64-v8a/libavformat.so | #EXT-X-KEY:METHOD=AES-128,URI="%s" |
| lib/arm64-v8a/libavformat.so | 0123456789abcdef |
| lib/arm64-v8a/libavformat.so | 0123456789ABCDEF |
| lib/arm64-v8a/libavformat.so | 1FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409 |
| lib/arm64-v8a/libavformat.so | 77214d4b196a87cd520045fd20a51d67 |
| lib/arm64-v8a/libavformat.so | 77214d4b196a87cd520045fd2a51d673 |
| lib/arm64-v8a/libavformat.so | 8$4,6-9'$6.:*?#1pHhX~AeSlZrNbS |
| lib/arm64-v8a/libavformat.so | Aarch64 AES was detected |
| lib/arm64-v8a/libavformat.so | AES decryption initialization vector |
| lib/arm64-v8a/libavformat.so | AES decryption key |
| lib/arm64-v8a/libavformat.so | AES encryption initialization vector |
| lib/arm64-v8a/libavformat.so | AES encryption key |
| lib/arm64-v8a/libavformat.so | AES encryption/decryption initialization vector |
| lib/arm64-v8a/libavformat.so | AES encryption/decryption key |
| lib/arm64-v8a/libavformat.so | aes_aarch64_cipher_setkey |
| lib/arm64-v8a/libavformat.so | aes_aarch64_decrypt |
| lib/arm64-v8a/libavformat.so | aes_aarch64_encrypt |
| lib/arm64-v8a/libavformat.so | aes_ccm_aead_decrypt |
| lib/arm64-v8a/libavformat.so | aes_ccm_aead_encrypt |
| lib/arm64-v8a/libavformat.so | aes_ccm_cipher_init |
| lib/arm64-v8a/libavformat.so | aes_cipher_init |
| lib/arm64-v8a/libavformat.so | AES_CM_128_HMAC_SHA1_32 |
| lib/arm64-v8a/libavformat.so | AES_CM_128_HMAC_SHA1_80 |
| lib/arm64-v8a/libavformat.so | aes_gcm_aead_decrypt |
| lib/arm64-v8a/libavformat.so | aes_gcm_aead_encrypt |
| lib/arm64-v8a/libavformat.so | aes_gcm_auth |
| lib/arm64-v8a/libavformat.so | aes_gcm_cipher_init |
| lib/arm64-v8a/libavformat.so | aes_gcm_cipher_setkey |
| lib/arm64-v8a/libavformat.so | aes_gcm_decrypt |
| lib/arm64-v8a/libavformat.so | aes_gcm_encrypt |
| lib/arm64-v8a/libavformat.so | aes_gcm_setiv |
| lib/arm64-v8a/libavformat.so | aes_setiv |
| lib/arm64-v8a/libavformat.so | AES-128 IV for Audible AAXC files |
| lib/arm64-v8a/libavformat.so | AES-128 Key for Audible AAXC files |
| lib/arm64-v8a/libavformat.so | AES-128-CBC |
| lib/arm64-v8a/libavformat.so | AES-128-CCM |
| lib/arm64-v8a/libavformat.so | AES-128-CCM-8 |
| lib/arm64-v8a/libavformat.so | AES-128-CFB8 |
| lib/arm64-v8a/libavformat.so | AES-128-GCM |
| lib/arm64-v8a/libavformat.so | AES-128-SIV |
| lib/arm64-v8a/libavformat.so | AES-128-XTS |
| lib/arm64-v8a/libavformat.so | AES-192-CBC |
| lib/arm64-v8a/libavformat.so | AES-192-CFB8 |
| lib/arm64-v8a/libavformat.so | AES-192-GCM |
| lib/arm64-v8a/libavformat.so | AES-256-CBC |
| lib/arm64-v8a/libavformat.so | AES-256-CCM |
| lib/arm64-v8a/libavformat.so | AES-256-CCM-8 |
| lib/arm64-v8a/libavformat.so | AES-256-CFB8 |
| lib/arm64-v8a/libavformat.so | AES-256-GCM |
| lib/arm64-v8a/libavformat.so | AES-256-SIV |
| lib/arm64-v8a/libavformat.so | AES-256-XTS |
| lib/arm64-v8a/libavformat.so | aes-cbc-aarch64.c |
| lib/arm64-v8a/libavformat.so | aes-ccm-aarch64.c |
| lib/arm64-v8a/libavformat.so | AES-CMAC-128 |
| lib/arm64-v8a/libavformat.so | AES-CMAC-256 |
| lib/arm64-v8a/libavformat.so | aes-decrypt-internal.c |
| lib/arm64-v8a/libavformat.so | aes-encrypt-internal.c |
| lib/arm64-v8a/libavformat.so | aes-gcm-aarch64.c |
| lib/arm64-v8a/libavformat.so | AES-GMAC-128 |
| lib/arm64-v8a/libavformat.so | AES-GMAC-192 |
| lib/arm64-v8a/libavformat.so | AES-GMAC-256 |
| lib/arm64-v8a/libavformat.so | aes-set-key-internal.c |
| lib/arm64-v8a/libavformat.so | aes128 |
| lib/arm64-v8a/libavformat.so | aes128-decrypt.c |
| lib/arm64-v8a/libavformat.so | aes128-encrypt.c |
| lib/arm64-v8a/libavformat.so | aes192-decrypt.c |
| lib/arm64-v8a/libavformat.so | aes192-encrypt.c |
| lib/arm64-v8a/libavformat.so | aes256 |
| lib/arm64-v8a/libavformat.so | aes256-decrypt.c |
| lib/arm64-v8a/libavformat.so | aes256-encrypt.c |
| lib/arm64-v8a/libavformat.so | av_aes_alloc |
| lib/arm64-v8a/libavformat.so | av_aes_crypt |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_alloc |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_crypt |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_free |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_get_iv |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_increment_iv |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_init |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_set_full_iv |
| lib/arm64-v8a/libavformat.so | av_aes_ctr_set_random_iv |
| lib/arm64-v8a/libavformat.so | av_aes_init |
| lib/arm64-v8a/libavformat.so | cenc-aes-ctr |
| lib/arm64-v8a/libavformat.so | CLIENT_EARLY_TRAFFIC_SECRET |
| lib/arm64-v8a/libavformat.so | CLIENT_HANDSHAKE_TRAFFIC_SECRET |
| lib/arm64-v8a/libavformat.so | CLIENT_TRAFFIC_SECRET_0 |
| lib/arm64-v8a/libavformat.so | Configures the encryption scheme, allowed values are none, cenc-aes-ctr |
| lib/arm64-v8a/libavformat.so | EARLY_EXPORTER_SECRET |
| lib/arm64-v8a/libavformat.so | ecc_shared_secret |
| lib/arm64-v8a/libavformat.so | enable AES128 encryption support |
| lib/arm64-v8a/libavformat.so | Error in password/key file. |
| lib/arm64-v8a/libavformat.so | Error in provided password for key to be loaded in TPM. |
| lib/arm64-v8a/libavformat.so | Error in provided SRK password for TPM. |
| lib/arm64-v8a/libavformat.so | error reading D-10 aes3 frame |
| lib/arm64-v8a/libavformat.so | EXPORTER_SECRET |
| lib/arm64-v8a/libavformat.so | ext_master_secret.c |
| lib/arm64-v8a/libavformat.so | extended master secret |
| lib/arm64-v8a/libavformat.so | Extended Master Secret |
| lib/arm64-v8a/libavformat.so | FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551 |
| lib/arm64-v8a/libavformat.so | FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831 |
| lib/arm64-v8a/libavformat.so | FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D |
| lib/arm64-v8a/libavformat.so | ffffffffffffffffffffffffffffffff6c611070995ad10045841b09b761b893 |
| lib/arm64-v8a/libavformat.so | FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973 |
| lib/arm64-v8a/libavformat.so | ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff27e69532f48d89116ff22b8d4e0560609b4b38abfad2b85dcacdb1411f10b275 |
| lib/arm64-v8a/libavformat.so | ftp-anonymous-password |
| lib/arm64-v8a/libavformat.so | ftp-password |
| lib/arm64-v8a/libavformat.so | generate_early_secrets |
| lib/arm64-v8a/libavformat.so | GNUTLS_AES_128_CCM_8_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_AES_128_CCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DH_ANON_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DH_ANON_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DH_ANON_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DH_ANON_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DH_ANON_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DH_ANON_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_DSS_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_DSS_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_DSS_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_DSS_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_DSS_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_DSS_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_PSK_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_DHE_RSA_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_E_INVALID_PASSWORD |
| lib/arm64-v8a/libavformat.so | GNUTLS_E_INVALID_PASSWORD_STRING |
| lib/arm64-v8a/libavformat.so | GNUTLS_E_TPM_KEY_PASSWORD_ERROR |
| lib/arm64-v8a/libavformat.so | GNUTLS_E_TPM_SRK_PASSWORD_ERROR |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDH_ANON_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDH_ANON_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_ECDSA_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_PSK_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_PSK_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_PSK_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_PSK_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_RSA_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_RSA_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_RSA_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_RSA_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_RSA_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_ECDHE_RSA_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_PSK_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_PSK_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_PSK_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_PSK_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_PSK_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_PSK_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_RSA_PSK_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | GNUTLS_SRP_SHA_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_SRP_SHA_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_SRP_SHA_DSS_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_SRP_SHA_DSS_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_SRP_SHA_RSA_AES_128_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | GNUTLS_SRP_SHA_RSA_AES_256_CBC_SHA1 |
| lib/arm64-v8a/libavformat.so | gnutls_utf8_password_normalize |
| lib/arm64-v8a/libavformat.so | Incorrect username/password |
| lib/arm64-v8a/libavformat.so | INT: MASTER SECRET[%d]: %s |
| lib/arm64-v8a/libavformat.so | INT: PREMASTER SECRET[%d]: %s |
| lib/arm64-v8a/libavformat.so | master secret |
| lib/arm64-v8a/libavformat.so | nonce_length <= AES_BLOCK_SIZE |
| lib/arm64-v8a/libavformat.so | nopassword |
| lib/arm64-v8a/libavformat.so | openssl_hash_password |
| lib/arm64-v8a/libavformat.so | Overwriting -password <pass> with URI password! |
| lib/arm64-v8a/libavformat.so | P~AeS |
| lib/arm64-v8a/libavformat.so | Parsing error in password/key file. |
| lib/arm64-v8a/libavformat.so | password |
| lib/arm64-v8a/libavformat.so | password for anonymous login. E-mail address should be used. |
| lib/arm64-v8a/libavformat.so | password for FTP login. Overridden by whatever is in the URL. |
| lib/arm64-v8a/libavformat.so | PBES2-AES128-CBC |
| lib/arm64-v8a/libavformat.so | PBES2-AES192-CBC |
| lib/arm64-v8a/libavformat.so | PBES2-AES256-CBC |
| lib/arm64-v8a/libavformat.so | pkcs-12-SecretBag |
| lib/arm64-v8a/libavformat.so | pkcs-5-aes128-CBC-params |
| lib/arm64-v8a/libavformat.so | pkcs-5-aes192-CBC-params |
| lib/arm64-v8a/libavformat.so | pkcs-5-aes256-CBC-params |
| lib/arm64-v8a/libavformat.so | pkcs-9-at-challengePassword |
| lib/arm64-v8a/libavformat.so | pkcs-9-challengePassword |
| lib/arm64-v8a/libavformat.so | PKIX1.pkcs-12-SecretBag |
| lib/arm64-v8a/libavformat.so | PKIX1.pkcs-5-aes128-CBC-params |
| lib/arm64-v8a/libavformat.so | PKIX1.pkcs-5-aes192-CBC-params |
| lib/arm64-v8a/libavformat.so | PKIX1.pkcs-5-aes256-CBC-params |
| lib/arm64-v8a/libavformat.so | PKIX1.pkcs-9-challengePassword |
| lib/arm64-v8a/libavformat.so | PQAeS~ |
| lib/arm64-v8a/libavformat.so | record_aes_gcm_encrypt_size |
| lib/arm64-v8a/libavformat.so | SAMPLE-AES |
| lib/arm64-v8a/libavformat.so | Secret bytes for Audible AAX files |
| lib/arm64-v8a/libavformat.so | Secret data: |
| lib/arm64-v8a/libavformat.so | secrets.c |
| lib/arm64-v8a/libavformat.so | secretTypeId |
| lib/arm64-v8a/libavformat.so | secretValue |
| lib/arm64-v8a/libavformat.so | SERVER_HANDSHAKE_TRAFFIC_SECRET |
| lib/arm64-v8a/libavformat.so | SERVER_TRAFFIC_SECRET_0 |
| lib/arm64-v8a/libavformat.so | set password |
| lib/arm64-v8a/libavformat.so | SRTP_AES128_CM_HMAC_SHA1_32 |
| lib/arm64-v8a/libavformat.so | SRTP_AES128_CM_HMAC_SHA1_80 |
| lib/arm64-v8a/libavformat.so | The given password contains invalid characters. |
| lib/arm64-v8a/libavformat.so | TLS_AES_128_CCM_8_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_AES_128_CCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_DH_anon_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DH_anon_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DH_anon_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DH_anon_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DH_anon_WITH_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DH_anon_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_DSS_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_DSS_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | TLS_DHE_PSK_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_ECDH_anon_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDH_anon_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_DHE_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_DHE_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_PSK_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_PSK_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_RSA_PSK_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_PSK_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_PSK_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_RSA_PSK_WITH_AES_256_CBC_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_PSK_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_128_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_128_CCM |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_128_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_128_GCM_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_256_CBC_SHA256 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_256_CCM |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_256_CCM_8 |
| lib/arm64-v8a/libavformat.so | TLS_RSA_WITH_AES_256_GCM_SHA384 |
| lib/arm64-v8a/libavformat.so | TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_SRP_SHA_WITH_AES_128_CBC_SHA |
| lib/arm64-v8a/libavformat.so | TLS_SRP_SHA_WITH_AES_256_CBC_SHA |
| lib/arm64-v8a/libavformat.so | void _nettle_aes_decrypt(unsigned int, const uint32_t *, const struct aes_table *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void _nettle_aes_encrypt(unsigned int, const uint32_t *, const struct aes_table *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void _nettle_aes_set_key(unsigned int, unsigned int, uint32_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void nettle_aes128_decrypt(const struct aes128_ctx *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void nettle_aes128_encrypt(const struct aes128_ctx *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void nettle_aes192_decrypt(const struct aes192_ctx *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void nettle_aes192_encrypt(const struct aes192_ctx *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void nettle_aes256_decrypt(const struct aes256_ctx *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavformat.so | void nettle_aes256_encrypt(const struct aes256_ctx *, size_t, uint8_t *, const uint8_t *) |
| lib/arm64-v8a/libavutil.so | 0123456789ABCDEFabcdef |
| lib/arm64-v8a/libavutil.so | 0A0123456789abcdef |
| lib/arm64-v8a/libavutil.so | 666666666666666666666666 |
| lib/arm64-v8a/libavutil.so | 666666666666670766666666 |
| lib/arm64-v8a/libavutil.so | av_aes_alloc |
| lib/arm64-v8a/libavutil.so | av_aes_crypt |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_alloc |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_crypt |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_free |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_get_iv |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_increment_iv |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_init |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_set_full_iv |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_set_iv |
| lib/arm64-v8a/libavutil.so | av_aes_ctr_set_random_iv |
| lib/arm64-v8a/libavutil.so | av_aes_init |
| lib/arm64-v8a/libavutil.so | av_aes_size |
| lib/arm64-v8a/libcontrol.so | [%s, %d][AES KEYS]Invalid AES Encrytion key(16bits), using default key |
| lib/arm64-v8a/libcontrol.so | [%s, %d][AES KEYS]Using defined AES Encrytion keys |
| lib/arm64-v8a/libcontrol.so | [%s, %d][AES KEYS]Using the default AES Encrytion keys |
| lib/arm64-v8a/libcontrol.so | [%s, %d]aes_block_num:%d , AES_BLOCKSIZE %d |
| lib/arm64-v8a/libcontrol.so | [16 bits AES Key]  - Option parameter, AES encrytion key |
| lib/arm64-v8a/libcontrol.so | <AP Infor FIle>    - Record AP's  ssid and password |
| lib/arm64-v8a/libcontrol.so | AES_cbc_decrypt_sdk |
| lib/arm64-v8a/libcontrol.so | AES_cbc_encrypt_sdk |
| lib/arm64-v8a/libcontrol.so | AES_convert_key |
| lib/arm64-v8a/libcontrol.so | AES_display |
| lib/arm64-v8a/libcontrol.so | AES_encrytion |
| lib/arm64-v8a/libcontrol.so | AES_generateSBox |
| lib/arm64-v8a/libcontrol.so | AES_set_key |
| lib/arm64-v8a/libcontrol.so | Usage:    simpleconfig <AP Infor FIle> [16 bits AES Key] |
| lib/arm64-v8a/libffmpeg.so | av_aes_crypt |

_其余 2706 条见 natives-strings.tsv_

### filesystem（81 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavcodec.so | /proc/cpuinfo |
| lib/arm64-v8a/libavcodec.so | /proc/self/auxv |
| lib/arm64-v8a/libavcodec.so | /sys/devices/system/cpu/possible |
| lib/arm64-v8a/libavcodec.so | /sys/devices/system/cpu/present |
| lib/arm64-v8a/libavformat.so | /data/misc/keychain/cacerts-added/ |
| lib/arm64-v8a/libavformat.so | /data/misc/keychain/cacerts-removed/ |
| lib/arm64-v8a/libavformat.so | /data/misc/keychain/cacerts-removed/%s |
| lib/arm64-v8a/libavutil.so | /tmp/%sXXXXXX |
| lib/arm64-v8a/libc++_shared.so | /tmp/980bfa06a14a76a548e4a431dc004d5e/sysroot/usr/include |
| lib/arm64-v8a/libc++_shared.so | /tmp/980bfa06a14a76a548e4a431dc004d5e/sysroot/usr/include/asm |
| lib/arm64-v8a/libc++_shared.so | /tmp/980bfa06a14a76a548e4a431dc004d5e/sysroot/usr/include/asm-generic |
| lib/arm64-v8a/libc++_shared.so | /tmp/980bfa06a14a76a548e4a431dc004d5e/sysroot/usr/include/linux |
| lib/arm64-v8a/libc++_shared.so | /tmp/980bfa06a14a76a548e4a431dc004d5e/sysroot/usr/include/sys |
| lib/arm64-v8a/libcontrol.so | /mnt/sdcard |
| lib/arm64-v8a/libdepth_net_transport.so | /mnt/sdcard |
| lib/arm64-v8a/libdepth_net_transport.so | /mnt/sdcard/ |
| lib/arm64-v8a/libffmpeg.so | /tmp/%sXXXXXX |
| lib/arm64-v8a/libffmpegkit_abidetect.so | /proc/cpuinfo |
| lib/arm64-v8a/libffmpegkit_abidetect.so | /proc/self/auxv |
| lib/arm64-v8a/libffmpegkit_abidetect.so | /sys/devices/system/cpu/possible |
| lib/arm64-v8a/libffmpegkit_abidetect.so | /sys/devices/system/cpu/present |
| lib/arm64-v8a/libijkffmpeg.so | /tmp/%sXXXXXX |
| lib/arm64-v8a/libpanorama_vr.so | /mnt/sdcard |
| lib/arm64-v8a/libpanorama_vr.so | /proc/cpuinfo |
| lib/arm64-v8a/libpanorama_vr.so | /tmp/%sXXXXXX |
| lib/arm64-v8a/libusb_transport.so | /mnt/sdcard |
| lib/arm64-v8a/libusb_transport.so | /mnt/sdcard/ |
| lib/arm64-v8a/libusb_transport.so | /mnt/sdcard/corrupted_still_%ld_%ld.jpg |
| lib/arm64-v8a/libusb_transport.so | /proc/bus/usb |
| lib/arm64-v8a/libusb_transport.so | /proc/bus/usb/%hhd/%hhd |
| lib/arm64-v8a/libusb_transport.so | /sys/bus/usb/devices |
| lib/armeabi-v7a/libavcodec_neon.so | /proc/cpuinfo |
| lib/armeabi-v7a/libavcodec_neon.so | /proc/self/auxv |
| lib/armeabi-v7a/libavcodec_neon.so | /sys/devices/system/cpu/possible |
| lib/armeabi-v7a/libavcodec_neon.so | /sys/devices/system/cpu/present |
| lib/armeabi-v7a/libavformat_neon.so | /data/misc/keychain/cacerts-added/ |
| lib/armeabi-v7a/libavformat_neon.so | /data/misc/keychain/cacerts-removed/ |
| lib/armeabi-v7a/libavformat_neon.so | /data/misc/keychain/cacerts-removed/%s |
| lib/armeabi-v7a/libavutil_neon.so | /proc/cpuinfo |
| lib/armeabi-v7a/libavutil_neon.so | /proc/self/auxv |
| lib/armeabi-v7a/libavutil_neon.so | /tmp/%sXXXXXX |
| lib/armeabi-v7a/libc++_shared.so | /data/local/tmp |
| lib/armeabi-v7a/libcontrol.so | /mnt/sdcard |
| lib/armeabi-v7a/libdepth_net_transport.so | /mnt/sdcard |
| lib/armeabi-v7a/libdepth_net_transport.so | /mnt/sdcard/ |
| lib/armeabi-v7a/libffmpeg.so | /proc/cpuinfo |
| lib/armeabi-v7a/libffmpeg.so | /proc/self/auxv |
| lib/armeabi-v7a/libffmpeg.so | /tmp/%sXXXXXX |
| lib/armeabi-v7a/libffmpegkit_abidetect.so | /proc/cpuinfo |
| lib/armeabi-v7a/libffmpegkit_abidetect.so | /proc/self/auxv |
| lib/armeabi-v7a/libffmpegkit_abidetect.so | /sys/devices/system/cpu/possible |
| lib/armeabi-v7a/libffmpegkit_abidetect.so | /sys/devices/system/cpu/present |
| lib/armeabi-v7a/libijkffmpeg.so | /proc/cpuinfo |
| lib/armeabi-v7a/libijkffmpeg.so | /proc/self/auxv |
| lib/armeabi-v7a/libijkffmpeg.so | /tmp/%sXXXXXX |
| lib/armeabi-v7a/libijksdl.so | /proc/cpuinfo |
| lib/armeabi-v7a/libpanorama_vr.so | /mnt/sdcard |
| lib/armeabi-v7a/libpanorama_vr.so | /proc/cpuinfo |
| lib/armeabi-v7a/libpanorama_vr.so | /proc/self/auxv |
| lib/armeabi-v7a/libpanorama_vr.so | /tmp/%sXXXXXX |
| lib/armeabi-v7a/libusb_transport.so | /mnt/sdcard |
| lib/armeabi-v7a/libusb_transport.so | /mnt/sdcard/ |
| lib/armeabi-v7a/libusb_transport.so | /mnt/sdcard/corrupted_still_%ld_%ld.jpg |
| lib/armeabi-v7a/libusb_transport.so | /proc/bus/usb |
| lib/armeabi-v7a/libusb_transport.so | /proc/bus/usb/%hhd/%hhd |
| lib/armeabi-v7a/libusb_transport.so | /sys/bus/usb/devices |
| lib/x86_64/libavformat.so | /data/misc/keychain/cacerts-added/ |
| lib/x86_64/libavformat.so | /data/misc/keychain/cacerts-removed/ |
| lib/x86_64/libavformat.so | /data/misc/keychain/cacerts-removed/%s |
| lib/x86_64/libavutil.so | /tmp/%sXXXXXX |
| lib/x86_64/libffmpegkit_abidetect.so | /proc/cpuinfo |
| lib/x86_64/libffmpegkit_abidetect.so | /sys/devices/system/cpu/possible |
| lib/x86_64/libffmpegkit_abidetect.so | /sys/devices/system/cpu/present |
| lib/x86/libavformat.so | /data/misc/keychain/cacerts-added/ |
| lib/x86/libavformat.so | /data/misc/keychain/cacerts-removed/ |
| lib/x86/libavformat.so | /data/misc/keychain/cacerts-removed/%s |
| lib/x86/libavutil.so | /tmp/%sXXXXXX |
| lib/x86/libffmpegkit_abidetect.so | /proc/cpuinfo |
| lib/x86/libffmpegkit_abidetect.so | /sys/devices/system/cpu/possible |
| lib/x86/libffmpegkit_abidetect.so | /sys/devices/system/cpu/present |
| lib/x86/libijkffmpeg.so | /tmp/%sXXXXXX |

### httpPath（165 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavcodec.so | ?e=ql |
| lib/arm64-v8a/libavcodec.so | ?m=)T\|= |
| lib/arm64-v8a/libavcodec.so | ?u='@ |
| lib/arm64-v8a/libavformat.so | ?authmod=%s&user=%s |
| lib/arm64-v8a/libavformat.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/arm64-v8a/libavformat.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/arm64-v8a/libavformat.so | ?connect=1 |
| lib/arm64-v8a/libavformat.so | ?listen=1 |
| lib/arm64-v8a/libavformat.so | ?localport=%d |
| lib/arm64-v8a/libavformat.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/arm64-v8a/libavformat.so | ?reason=authfailed |
| lib/arm64-v8a/libavformat.so | ?reason=needauth |
| lib/arm64-v8a/libavformat.so | ?reason=nosuchuser |
| lib/arm64-v8a/libavformat.so | ?tcp_nodelay=%d |
| lib/arm64-v8a/libavformat.so | ?timeout=%ld |
| lib/arm64-v8a/libavformat.so | ?ttl=%d |
| lib/arm64-v8a/libavformat.so | ?ttl=%d&connect=1 |
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
| lib/arm64-v8a/libpanorama_vr.so | ?authmod=%s&user=%s |
| lib/arm64-v8a/libpanorama_vr.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/arm64-v8a/libpanorama_vr.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/arm64-v8a/libpanorama_vr.so | ?connect=1 |
| lib/arm64-v8a/libpanorama_vr.so | ?localport=%d |
| lib/arm64-v8a/libpanorama_vr.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/arm64-v8a/libpanorama_vr.so | ?m=)T\|= |
| lib/arm64-v8a/libpanorama_vr.so | ?reason=authfailed |
| lib/arm64-v8a/libpanorama_vr.so | ?reason=needauth |
| lib/arm64-v8a/libpanorama_vr.so | ?reason=nosuchuser |
| lib/arm64-v8a/libpanorama_vr.so | ?timeout=%d |
| lib/arm64-v8a/libpanorama_vr.so | ?ttl=%d |
| lib/arm64-v8a/libpanorama_vr.so | ?ttl=%d&connect=1 |
| lib/arm64-v8a/libpanorama_vr.so | ?u='@ |
| lib/arm64-v8a/libpanorama_vr.so | ?u='@^ |
| lib/armeabi-v7a/libavcodec_neon.so | ?m=)T\|= |
| lib/armeabi-v7a/libavcodec_neon.so | ?u='@ |
| lib/armeabi-v7a/libavformat_neon.so | ?authmod=%s&user=%s |
| lib/armeabi-v7a/libavformat_neon.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/armeabi-v7a/libavformat_neon.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/armeabi-v7a/libavformat_neon.so | ?connect=1 |
| lib/armeabi-v7a/libavformat_neon.so | ?listen=1 |
| lib/armeabi-v7a/libavformat_neon.so | ?localport=%d |
| lib/armeabi-v7a/libavformat_neon.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/armeabi-v7a/libavformat_neon.so | ?reason=authfailed |
| lib/armeabi-v7a/libavformat_neon.so | ?reason=needauth |
| lib/armeabi-v7a/libavformat_neon.so | ?reason=nosuchuser |
| lib/armeabi-v7a/libavformat_neon.so | ?tcp_nodelay=%d |
| lib/armeabi-v7a/libavformat_neon.so | ?timeout=%lld |
| lib/armeabi-v7a/libavformat_neon.so | ?ttl=%d |
| lib/armeabi-v7a/libavformat_neon.so | ?ttl=%d&connect=1 |
| lib/armeabi-v7a/libffmpeg.so | ?authmod=%s&user=%s |
| lib/armeabi-v7a/libffmpeg.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/armeabi-v7a/libffmpeg.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/armeabi-v7a/libffmpeg.so | ?connect=1 |
| lib/armeabi-v7a/libffmpeg.so | ?localport=%d |
| lib/armeabi-v7a/libffmpeg.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/armeabi-v7a/libffmpeg.so | ?m=)T\|= |
| lib/armeabi-v7a/libffmpeg.so | ?reason=authfailed |
| lib/armeabi-v7a/libffmpeg.so | ?reason=needauth |
| lib/armeabi-v7a/libffmpeg.so | ?reason=nosuchuser |
| lib/armeabi-v7a/libffmpeg.so | ?timeout=%d |
| lib/armeabi-v7a/libffmpeg.so | ?ttl=%d |
| lib/armeabi-v7a/libffmpeg.so | ?ttl=%d&connect=1 |
| lib/armeabi-v7a/libffmpeg.so | ?u='@ |
| lib/armeabi-v7a/libijkffmpeg.so | ?authmod=%s&user=%s |
| lib/armeabi-v7a/libijkffmpeg.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/armeabi-v7a/libijkffmpeg.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/armeabi-v7a/libijkffmpeg.so | ?connect=1 |
| lib/armeabi-v7a/libijkffmpeg.so | ?localport=%d |
| lib/armeabi-v7a/libijkffmpeg.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/armeabi-v7a/libijkffmpeg.so | ?m=)T\|= |
| lib/armeabi-v7a/libijkffmpeg.so | ?reason=authfailed |
| lib/armeabi-v7a/libijkffmpeg.so | ?reason=needauth |
| lib/armeabi-v7a/libijkffmpeg.so | ?reason=nosuchuser |
| lib/armeabi-v7a/libijkffmpeg.so | ?timeout=%d |
| lib/armeabi-v7a/libijkffmpeg.so | ?ttl=%d |
| lib/armeabi-v7a/libijkffmpeg.so | ?u='@ |
| lib/armeabi-v7a/libpanorama_vr.so | ?authmod=%s&user=%s |
| lib/armeabi-v7a/libpanorama_vr.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/armeabi-v7a/libpanorama_vr.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/armeabi-v7a/libpanorama_vr.so | ?connect=1 |
| lib/armeabi-v7a/libpanorama_vr.so | ?localport=%d |
| lib/armeabi-v7a/libpanorama_vr.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/armeabi-v7a/libpanorama_vr.so | ?m=)T\|= |
| lib/armeabi-v7a/libpanorama_vr.so | ?reason=authfailed |
| lib/armeabi-v7a/libpanorama_vr.so | ?reason=needauth |
| lib/armeabi-v7a/libpanorama_vr.so | ?reason=nosuchuser |
| lib/armeabi-v7a/libpanorama_vr.so | ?timeout=%d |
| lib/armeabi-v7a/libpanorama_vr.so | ?ttl=%d |
| lib/armeabi-v7a/libpanorama_vr.so | ?ttl=%d&connect=1 |
| lib/armeabi-v7a/libpanorama_vr.so | ?u='@ |
| lib/x86_64/libavcodec.so | ?m=)T\|= |
| lib/x86_64/libavcodec.so | ?q=Z@ |
| lib/x86_64/libavcodec.so | ?u='@ |
| lib/x86_64/libavformat.so | ?authmod=%s&user=%s |
| lib/x86_64/libavformat.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/x86_64/libavformat.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/x86_64/libavformat.so | ?connect=1 |
| lib/x86_64/libavformat.so | ?listen=H |
| lib/x86_64/libavformat.so | ?localport=%d |
| lib/x86_64/libavformat.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/x86_64/libavformat.so | ?reason=authfailed |
| lib/x86_64/libavformat.so | ?reason=needauth |
| lib/x86_64/libavformat.so | ?reason=nosuchuser |
| lib/x86_64/libavformat.so | ?t=E1 |
| lib/x86_64/libavformat.so | ?tcp_nodelay=%d |
| lib/x86_64/libavformat.so | ?timeout=%ld |
| lib/x86_64/libavformat.so | ?ttl=%d |
| lib/x86_64/libavformat.so | ?ttl=%d&connect=1 |
| lib/x86/libavcodec.so | ?m=)T\|= |
| lib/x86/libavcodec.so | ?q=Z@ |
| lib/x86/libavcodec.so | ?u='@ |
| lib/x86/libavformat.so | ?authmod=%s&user=%s |
| lib/x86/libavformat.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/x86/libavformat.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/x86/libavformat.so | ?connect=1 |
| lib/x86/libavformat.so | ?localport=%d |
| lib/x86/libavformat.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/x86/libavformat.so | ?reason=authfailed |
| lib/x86/libavformat.so | ?reason=needauth |
| lib/x86/libavformat.so | ?reason=nosuchuser |
| lib/x86/libavformat.so | ?tcp_nodelay=%d |
| lib/x86/libavformat.so | ?timeout=%lld |
| lib/x86/libavformat.so | ?ttl=%d |
| lib/x86/libavformat.so | ?ttl=%d&connect=1 |
| lib/x86/libijkffmpeg.so | ?authmod=%s&user=%s |
| lib/x86/libijkffmpeg.so | ?authmod=%s&user=%s&challenge=%s&response=%s |
| lib/x86/libijkffmpeg.so | ?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s |
| lib/x86/libijkffmpeg.so | ?connect=1 |
| lib/x86/libijkffmpeg.so | ?listen=1 |
| lib/x86/libijkffmpeg.so | ?localport=%d |
| lib/x86/libijkffmpeg.so | ?localport=%d&ttl=%d&connect=%d&write_to_source=%d |
| lib/x86/libijkffmpeg.so | ?m=)T\|= |
| lib/x86/libijkffmpeg.so | ?reason=authfailed |
| lib/x86/libijkffmpeg.so | ?reason=needauth |
| lib/x86/libijkffmpeg.so | ?reason=nosuchuser |
| lib/x86/libijkffmpeg.so | ?timeout=%d |
| lib/x86/libijkffmpeg.so | ?ttl=%d |
| lib/x86/libijkffmpeg.so | ?u='@ |

### ip（170 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavformat.so | 1.3.101.110 |
| lib/arm64-v8a/libavformat.so | 1.3.101.111 |
| lib/arm64-v8a/libavformat.so | 1.3.101.112 |
| lib/arm64-v8a/libavformat.so | 1.3.101.113 |
| lib/arm64-v8a/libavformat.so | 127.0.0.1 |
| lib/arm64-v8a/libavformat.so | 2.5.29.14 |
| lib/arm64-v8a/libavformat.so | 2.5.29.15 |
| lib/arm64-v8a/libavformat.so | 2.5.29.16 |
| lib/arm64-v8a/libavformat.so | 2.5.29.17 |
| lib/arm64-v8a/libavformat.so | 2.5.29.18 |
| lib/arm64-v8a/libavformat.so | 2.5.29.19 |
| lib/arm64-v8a/libavformat.so | 2.5.29.30 |
| lib/arm64-v8a/libavformat.so | 2.5.29.31 |
| lib/arm64-v8a/libavformat.so | 2.5.29.32 |
| lib/arm64-v8a/libavformat.so | 2.5.29.35 |
| lib/arm64-v8a/libavformat.so | 2.5.29.37 |
| lib/arm64-v8a/libavformat.so | 2.5.29.54 |
| lib/arm64-v8a/libavformat.so | 2.5.4.10 |
| lib/arm64-v8a/libavformat.so | 2.5.4.11 |
| lib/arm64-v8a/libavformat.so | 2.5.4.12 |
| lib/arm64-v8a/libavformat.so | 2.5.4.13 |
| lib/arm64-v8a/libavformat.so | 2.5.4.15 |
| lib/arm64-v8a/libavformat.so | 2.5.4.17 |
| lib/arm64-v8a/libavformat.so | 2.5.4.20 |
| lib/arm64-v8a/libavformat.so | 2.5.4.3 |
| lib/arm64-v8a/libavformat.so | 2.5.4.4 |
| lib/arm64-v8a/libavformat.so | 2.5.4.41 |
| lib/arm64-v8a/libavformat.so | 2.5.4.42 |
| lib/arm64-v8a/libavformat.so | 2.5.4.43 |
| lib/arm64-v8a/libavformat.so | 2.5.4.44 |
| lib/arm64-v8a/libavformat.so | 2.5.4.46 |
| lib/arm64-v8a/libavformat.so | 2.5.4.5 |
| lib/arm64-v8a/libavformat.so | 2.5.4.6 |
| lib/arm64-v8a/libavformat.so | 2.5.4.65 |
| lib/arm64-v8a/libavformat.so | 2.5.4.7 |
| lib/arm64-v8a/libavformat.so | 2.5.4.8 |
| lib/arm64-v8a/libavformat.so | 2.5.4.9 |
| lib/arm64-v8a/libavformat.so | 224.2.127.254 |
| lib/arm64-v8a/libcontrol.so | 127.0.0.1 |
| lib/arm64-v8a/libcontrol.so | 234.168.168.168 |
| lib/arm64-v8a/libffmpeg.so | 127.0.0.1 |
| lib/arm64-v8a/libffmpeg.so | 224.2.127.254 |
| lib/arm64-v8a/libpanorama_vr.so | 1.2.0.4 |
| lib/arm64-v8a/libpanorama_vr.so | 127.0.0.1 |
| lib/arm64-v8a/libpanorama_vr.so | 224.2.127.254 |
| lib/arm64-v8a/libpanorama_vr.so | 228.67.43.91 |
| lib/arm64-v8a/libreliant.so | 127.0.0.1 |
| lib/armeabi-v7a/libavformat_neon.so | 1.3.101.110 |
| lib/armeabi-v7a/libavformat_neon.so | 1.3.101.111 |
| lib/armeabi-v7a/libavformat_neon.so | 1.3.101.112 |
| lib/armeabi-v7a/libavformat_neon.so | 1.3.101.113 |
| lib/armeabi-v7a/libavformat_neon.so | 127.0.0.1 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.14 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.15 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.16 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.17 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.18 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.19 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.30 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.31 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.32 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.35 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.37 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.29.54 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.10 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.11 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.12 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.13 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.15 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.17 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.20 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.3 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.4 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.41 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.42 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.43 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.44 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.46 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.5 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.6 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.65 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.7 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.8 |
| lib/armeabi-v7a/libavformat_neon.so | 2.5.4.9 |
| lib/armeabi-v7a/libavformat_neon.so | 224.2.127.254 |
| lib/armeabi-v7a/libcontrol.so | 127.0.0.1 |
| lib/armeabi-v7a/libcontrol.so | 234.168.168.168 |
| lib/armeabi-v7a/libffmpeg.so | 127.0.0.1 |
| lib/armeabi-v7a/libffmpeg.so | 224.2.127.254 |
| lib/armeabi-v7a/libpanorama_vr.so | 1.2.0.4 |
| lib/armeabi-v7a/libpanorama_vr.so | 127.0.0.1 |
| lib/armeabi-v7a/libpanorama_vr.so | 224.2.127.254 |
| lib/armeabi-v7a/libpanorama_vr.so | 228.67.43.91 |
| lib/armeabi-v7a/libreliant.so | 127.0.0.1 |
| lib/x86_64/libavformat.so | 1.3.101.110 |
| lib/x86_64/libavformat.so | 1.3.101.111 |
| lib/x86_64/libavformat.so | 1.3.101.112 |
| lib/x86_64/libavformat.so | 1.3.101.113 |
| lib/x86_64/libavformat.so | 127.0.0.1 |
| lib/x86_64/libavformat.so | 2.5.29.14 |
| lib/x86_64/libavformat.so | 2.5.29.15 |
| lib/x86_64/libavformat.so | 2.5.29.16 |
| lib/x86_64/libavformat.so | 2.5.29.17 |
| lib/x86_64/libavformat.so | 2.5.29.18 |
| lib/x86_64/libavformat.so | 2.5.29.19 |
| lib/x86_64/libavformat.so | 2.5.29.30 |
| lib/x86_64/libavformat.so | 2.5.29.31 |
| lib/x86_64/libavformat.so | 2.5.29.32 |
| lib/x86_64/libavformat.so | 2.5.29.35 |
| lib/x86_64/libavformat.so | 2.5.29.37 |
| lib/x86_64/libavformat.so | 2.5.29.54 |
| lib/x86_64/libavformat.so | 2.5.4.10 |
| lib/x86_64/libavformat.so | 2.5.4.11 |
| lib/x86_64/libavformat.so | 2.5.4.12 |
| lib/x86_64/libavformat.so | 2.5.4.13 |
| lib/x86_64/libavformat.so | 2.5.4.15 |
| lib/x86_64/libavformat.so | 2.5.4.17 |
| lib/x86_64/libavformat.so | 2.5.4.20 |
| lib/x86_64/libavformat.so | 2.5.4.3 |
| lib/x86_64/libavformat.so | 2.5.4.4 |
| lib/x86_64/libavformat.so | 2.5.4.41 |
| lib/x86_64/libavformat.so | 2.5.4.42 |
| lib/x86_64/libavformat.so | 2.5.4.43 |
| lib/x86_64/libavformat.so | 2.5.4.44 |
| lib/x86_64/libavformat.so | 2.5.4.46 |
| lib/x86_64/libavformat.so | 2.5.4.5 |
| lib/x86_64/libavformat.so | 2.5.4.6 |
| lib/x86_64/libavformat.so | 2.5.4.65 |
| lib/x86_64/libavformat.so | 2.5.4.7 |
| lib/x86_64/libavformat.so | 2.5.4.8 |
| lib/x86_64/libavformat.so | 2.5.4.9 |
| lib/x86_64/libavformat.so | 224.2.127.254 |
| lib/x86/libavformat.so | 1.3.101.110 |
| lib/x86/libavformat.so | 1.3.101.111 |
| lib/x86/libavformat.so | 1.3.101.112 |
| lib/x86/libavformat.so | 1.3.101.113 |
| lib/x86/libavformat.so | 127.0.0.1 |
| lib/x86/libavformat.so | 2.5.29.14 |
| lib/x86/libavformat.so | 2.5.29.15 |
| lib/x86/libavformat.so | 2.5.29.16 |
| lib/x86/libavformat.so | 2.5.29.17 |
| lib/x86/libavformat.so | 2.5.29.18 |
| lib/x86/libavformat.so | 2.5.29.19 |
| lib/x86/libavformat.so | 2.5.29.30 |
| lib/x86/libavformat.so | 2.5.29.31 |
| lib/x86/libavformat.so | 2.5.29.32 |
| lib/x86/libavformat.so | 2.5.29.35 |
| lib/x86/libavformat.so | 2.5.29.37 |
| lib/x86/libavformat.so | 2.5.29.54 |
| lib/x86/libavformat.so | 2.5.4.10 |
| lib/x86/libavformat.so | 2.5.4.11 |
| lib/x86/libavformat.so | 2.5.4.12 |
| lib/x86/libavformat.so | 2.5.4.13 |
| lib/x86/libavformat.so | 2.5.4.15 |
| lib/x86/libavformat.so | 2.5.4.17 |
| lib/x86/libavformat.so | 2.5.4.20 |
| lib/x86/libavformat.so | 2.5.4.3 |
| lib/x86/libavformat.so | 2.5.4.4 |
| lib/x86/libavformat.so | 2.5.4.41 |
| lib/x86/libavformat.so | 2.5.4.42 |
| lib/x86/libavformat.so | 2.5.4.43 |
| lib/x86/libavformat.so | 2.5.4.44 |
| lib/x86/libavformat.so | 2.5.4.46 |
| lib/x86/libavformat.so | 2.5.4.5 |
| lib/x86/libavformat.so | 2.5.4.6 |
| lib/x86/libavformat.so | 2.5.4.65 |
| lib/x86/libavformat.so | 2.5.4.7 |
| lib/x86/libavformat.so | 2.5.4.8 |
| lib/x86/libavformat.so | 2.5.4.9 |
| lib/x86/libavformat.so | 224.2.127.254 |

### jpegExif（17 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavcodec.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/arm64-v8a/libavcodec.so | IFD offset is greater than image size |
| lib/arm64-v8a/libffmpeg.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/arm64-v8a/libffmpeg.so | IFD offset is greater than image size |
| lib/arm64-v8a/libpanorama_vr.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/arm64-v8a/libpanorama_vr.so | IFD offset is greater than image size |
| lib/armeabi-v7a/libavcodec_neon.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/armeabi-v7a/libavcodec_neon.so | IFD offset is greater than image size |
| lib/armeabi-v7a/libffmpeg.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/armeabi-v7a/libffmpeg.so | IFD offset is greater than image size |
| lib/armeabi-v7a/libijkffmpeg.so | IFDJ+FzD |
| lib/armeabi-v7a/libpanorama_vr.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/armeabi-v7a/libpanorama_vr.so | IFD offset is greater than image size |
| lib/x86_64/libavcodec.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/x86_64/libavcodec.so | IFD offset is greater than image size |
| lib/x86/libavcodec.so | EXIF chunk present, but Exif bit not set in the VP8X header |
| lib/x86/libavcodec.so | IFD offset is greater than image size |

### mdnsDiscovery（9 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_cleanup_local |
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_get_local |
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_init_local |
| lib/arm64-v8a/libijkffmpeg.so | CRYPTO_THREAD_set_local |
| lib/armeabi-v7a/libc++_shared.so | __unw_init_local |
| lib/armeabi-v7a/libc++_shared.so | unw_init_local |
| lib/armeabi-v7a/libdepth_net_transport.so | unw_init_local |
| lib/armeabi-v7a/libijkffmpeg.so | unw_init_local |
| lib/armeabi-v7a/libusb_transport.so | unw_init_local |

### protocolSymbol（1124 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavcodec.so | aac_adtstoasc |
| lib/arm64-v8a/libavcodec.so | aac_coder |
| lib/arm64-v8a/libavcodec.so | aac_eld |
| lib/arm64-v8a/libavcodec.so | aac_fixed |
| lib/arm64-v8a/libavcodec.so | aac_he |
| lib/arm64-v8a/libavcodec.so | aac_he_v2 |
| lib/arm64-v8a/libavcodec.so | aac_is |
| lib/arm64-v8a/libavcodec.so | aac_latm |
| lib/arm64-v8a/libavcodec.so | aac_ld |
| lib/arm64-v8a/libavcodec.so | aac_low |
| lib/arm64-v8a/libavcodec.so | aac_ltp |
| lib/arm64-v8a/libavcodec.so | aac_main |
| lib/arm64-v8a/libavcodec.so | aac_ms |
| lib/arm64-v8a/libavcodec.so | aac_pce |
| lib/arm64-v8a/libavcodec.so | aac_pns |
| lib/arm64-v8a/libavcodec.so | aac_pred |
| lib/arm64-v8a/libavcodec.so | aac_ssr |
| lib/arm64-v8a/libavcodec.so | aac_tns |
| lib/arm64-v8a/libavcodec.so | h264 profile |
| lib/arm64-v8a/libavcodec.so | h264 profile not found |
| lib/arm64-v8a/libavcodec.so | h264_mediacodec |
| lib/arm64-v8a/libavcodec.so | h264_metadata |
| lib/arm64-v8a/libavcodec.so | h264_metadata_bsf |
| lib/arm64-v8a/libavcodec.so | h264_metadata=crop_right=%d:crop_bottom=%d |
| lib/arm64-v8a/libavcodec.so | h264_mp4toannexb |
| lib/arm64-v8a/libavcodec.so | h264_redundant_pps |
| lib/arm64-v8a/libavcodec.so | h264_slice_header_init() failed |
| lib/arm64-v8a/libavcodec.so | h264_v4l2m2m |
| lib/arm64-v8a/libavcodec.so | h264_v4l2m2m_decoder |
| lib/arm64-v8a/libavcodec.so | h264_v4l2m2m_encoder |
| lib/arm64-v8a/libavcodec.so | rtpqmotv_bTR_^} |
| lib/arm64-v8a/libavcodec.so | sscanf |
| lib/arm64-v8a/libavdevice.so | sscanf |
| lib/arm64-v8a/libavfilter.so | aacute |
| lib/arm64-v8a/libavfilter.so | sscanf |
| lib/arm64-v8a/libavformat.so | aac bitstream error |
| lib/arm64-v8a/libavformat.so | aac_adtstoasc |
| lib/arm64-v8a/libavformat.so | aac_seq_header_detect |
| lib/arm64-v8a/libavformat.so | aac,adts |
| lib/arm64-v8a/libavformat.so | aac,m4a,m4s,m4v,mov,mp4,webm,ts |
| lib/arm64-v8a/libavformat.so | aacute |
| lib/arm64-v8a/libavformat.so | h264 profile not supported |
| lib/arm64-v8a/libavformat.so | h264_mode0 |
| lib/arm64-v8a/libavformat.so | h264_mp4toannexb |
| lib/arm64-v8a/libavformat.so | h264_mp4toannexb bitstream filter required for H.264 streams |
| lib/arm64-v8a/libavformat.so | h264_mp4toannexb filter failed to receive output packet |
| lib/arm64-v8a/libavformat.so | h264_mp4toannexb filter failed to send input packet |
| lib/arm64-v8a/libavformat.so | h264,264 |
| lib/arm64-v8a/libavformat.so | rtp_flags |
| lib/arm64-v8a/libavformat.so | rtp_mpegts |
| lib/arm64-v8a/libavformat.so | rtp_mpegts muxer |
| lib/arm64-v8a/libavformat.so | rtp_muxer_options |
| lib/arm64-v8a/libavformat.so | rtp_read_header(): not enough buffer space for sdp-headers |
| lib/arm64-v8a/libavformat.so | rtp_send_data size=%d |
| lib/arm64-v8a/libavformat.so | rtpdec: failed to set prft |
| lib/arm64-v8a/libavformat.so | rtpflags |
| lib/arm64-v8a/libavformat.so | rtphint |
| lib/arm64-v8a/libavformat.so | rtpmap: |
| lib/arm64-v8a/libavformat.so | rtsp_flags |
| lib/arm64-v8a/libavformat.so | rtsp_transport |
| lib/arm64-v8a/libavformat.so | rtsp: |
| lib/arm64-v8a/libavformat.so | rtsp:// |
| lib/arm64-v8a/libavformat.so | rtsps |
| lib/arm64-v8a/libavformat.so | rtsps: |
| lib/arm64-v8a/libavformat.so | socket |
| lib/arm64-v8a/libavformat.so | socket failed |
| lib/arm64-v8a/libavformat.so | socket option UDPLITE_RECV_CSCOV not available |
| lib/arm64-v8a/libavformat.so | socket option UDPLITE_SEND_CSCOV not available |
| lib/arm64-v8a/libavformat.so | sscanf |
| lib/arm64-v8a/libavutil.so | sscanf |
| lib/arm64-v8a/libcontrol.so | icatch_%s_sdk_%s_%s.log |
| lib/arm64-v8a/libcontrol.so | icatch_get_dev_prop_desc |
| lib/arm64-v8a/libcontrol.so | icatch_get_dev_prop_desc error: %04x |
| lib/arm64-v8a/libcontrol.so | icatch_get_dev_prop_value |
| lib/arm64-v8a/libcontrol.so | icatch_get_dev_prop_value error |
| lib/arm64-v8a/libcontrol.so | icatch_set_dev_prop_desc error: %d |
| lib/arm64-v8a/libcontrol.so | icatch_set_dev_prop_value |
| lib/arm64-v8a/libcontrol.so | ptp client connect success |
| lib/arm64-v8a/libcontrol.so | ptp client connecting |
| lib/arm64-v8a/libcontrol.so | ptp conn %s |
| lib/arm64-v8a/libcontrol.so | ptp disconnected, check result: %s. |
| lib/arm64-v8a/libcontrol.so | ptp flow |
| lib/arm64-v8a/libcontrol.so | ptp_add_event |
| lib/arm64-v8a/libcontrol.so | ptp_add_object_to_cache |
| lib/arm64-v8a/libcontrol.so | ptp_chdk_call |
| lib/arm64-v8a/libcontrol.so | ptp_chdk_exec_lua |
| lib/arm64-v8a/libcontrol.so | ptp_chdk_get_memory |
| lib/arm64-v8a/libcontrol.so | ptp_chdk_get_paramdata |
| lib/arm64-v8a/libcontrol.so | ptp_chdk_get_propcase |
| lib/arm64-v8a/libcontrol.so | ptp_chdk_get_script_output |
| lib/arm64-v8a/libcontrol.so | ptp_chdk_get_video_settings |
| lib/arm64-v8a/libcontrol.so | ptp_check_event |
| lib/arm64-v8a/libcontrol.so | ptp_debug |
| lib/arm64-v8a/libcontrol.so | ptp_deleteobject |
| lib/arm64-v8a/libcontrol.so | ptp_destroy_object_prop |
| lib/arm64-v8a/libcontrol.so | ptp_destroy_object_prop_list |
| lib/arm64-v8a/libcontrol.so | ptp_error |
| lib/arm64-v8a/libcontrol.so | ptp_event_issupported |
| lib/arm64-v8a/libcontrol.so | ptp_find_object_prop_in_cache |
| lib/arm64-v8a/libcontrol.so | ptp_formatstore ret = 0x%x |
| lib/arm64-v8a/libcontrol.so | ptp_free_devicepropdesc |
| lib/arm64-v8a/libcontrol.so | ptp_free_devicepropvalue |
| lib/arm64-v8a/libcontrol.so | ptp_free_object |
| lib/arm64-v8a/libcontrol.so | ptp_free_objectinfo |
| lib/arm64-v8a/libcontrol.so | ptp_free_objectpropdesc |
| lib/arm64-v8a/libcontrol.so | ptp_free_params |
| lib/arm64-v8a/libcontrol.so | ptp_generic_no_data |
| lib/arm64-v8a/libcontrol.so | ptp_get_new_object_prop_entry |
| lib/arm64-v8a/libcontrol.so | ptp_get_one_event |
| lib/arm64-v8a/libcontrol.so | ptp_get_property_description |
| lib/arm64-v8a/libcontrol.so | ptp_getdeviceallpropdescs |
| lib/arm64-v8a/libcontrol.so | ptp_getdeviceinfo |
| lib/arm64-v8a/libcontrol.so | ptp_getdevicepropdesc |
| lib/arm64-v8a/libcontrol.so | ptp_getdevicepropvalue |
| lib/arm64-v8a/libcontrol.so | ptp_getfilesystemmanifest |
| lib/arm64-v8a/libcontrol.so | ptp_getnumobjects |
| lib/arm64-v8a/libcontrol.so | ptp_getobject |
| lib/arm64-v8a/libcontrol.so | ptp_getobject_to_handler |
| lib/arm64-v8a/libcontrol.so | ptp_getobject_to_handler %d |
| lib/arm64-v8a/libcontrol.so | ptp_getobject_tofd |
| lib/arm64-v8a/libcontrol.so | ptp_getobjecthandles |
| lib/arm64-v8a/libcontrol.so | ptp_getobjectinfo |
| lib/arm64-v8a/libcontrol.so | ptp_getpartialobject |
| lib/arm64-v8a/libcontrol.so | ptp_getstorageids |
| lib/arm64-v8a/libcontrol.so | ptp_getstorageinfo |
| lib/arm64-v8a/libcontrol.so | ptp_getstorageinfo ret = 0x%x |
| lib/arm64-v8a/libcontrol.so | ptp_getthumb |
| lib/arm64-v8a/libcontrol.so | ptp_icatch_set_customer_operation |
| lib/arm64-v8a/libcontrol.so | ptp_init_camerafile_handler %d |
| lib/arm64-v8a/libcontrol.so | ptp_init_camerafile_handler size: %d |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_getobjectpropdesc |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_getobjectproplist |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_getobjectproplist_single |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_getobjectpropssupported |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_getobjectpropvalue |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_getobjectquickview |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_getobjectreferences |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_sendobjectproplist |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_setobjectproplist |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_setobjectpropvalue |
| lib/arm64-v8a/libcontrol.so | ptp_mtp_setobjectreferences |
| lib/arm64-v8a/libcontrol.so | ptp_nikon_getptpipguid |
| lib/arm64-v8a/libcontrol.so | ptp_object_find |
| lib/arm64-v8a/libcontrol.so | ptp_object_find_or_insert |
| lib/arm64-v8a/libcontrol.so | ptp_object_want |
| lib/arm64-v8a/libcontrol.so | ptp_object_want: oid 0x%08x, want flags %x, have only %x? |
| lib/arm64-v8a/libcontrol.so | ptp_object_want: querying handle 0? |
| lib/arm64-v8a/libcontrol.so | ptp_objects_sort |
| lib/arm64-v8a/libcontrol.so | ptp_ofc_mtp_trans |
| lib/arm64-v8a/libcontrol.so | ptp_ofc_trans |
| lib/arm64-v8a/libcontrol.so | ptp_opc_trans |
| lib/arm64-v8a/libcontrol.so | ptp_opcode_mtp_trans |
| lib/arm64-v8a/libcontrol.so | ptp_opcode_trans |
| lib/arm64-v8a/libcontrol.so | ptp_opensession |
| lib/arm64-v8a/libcontrol.so | ptp_opensession returns %x |
| lib/arm64-v8a/libcontrol.so | ptp_operation_issupported |
| lib/arm64-v8a/libcontrol.so | ptp_perror |
| lib/arm64-v8a/libcontrol.so | ptp_property_issupported |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_close |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_connect |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_event_check |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_event_wait |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_getdata |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_getresp |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_senddata |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_senddata() len=%d but ret=%d |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_sendreq |
| lib/arm64-v8a/libcontrol.so | ptp_ptpip_sendreq() len =%d but ret=%d |
| lib/arm64-v8a/libcontrol.so | ptp_remove_object_from_cache |
| lib/arm64-v8a/libcontrol.so | ptp_render_mtp_propname |
| lib/arm64-v8a/libcontrol.so | ptp_render_ofc |
| lib/arm64-v8a/libcontrol.so | ptp_render_opcode |
| lib/arm64-v8a/libcontrol.so | ptp_render_property_value |
| lib/arm64-v8a/libcontrol.so | ptp_sendobject |
| lib/arm64-v8a/libcontrol.so | ptp_sendobject_from_handler |
| lib/arm64-v8a/libcontrol.so | ptp_sendobject_fromfd |
| lib/arm64-v8a/libcontrol.so | ptp_sendobjectinfo |
| lib/arm64-v8a/libcontrol.so | ptp_setdevicepropvalue |
| lib/arm64-v8a/libcontrol.so | ptp_strerror |
| lib/arm64-v8a/libcontrol.so | ptp_transaction |
| lib/arm64-v8a/libcontrol.so | ptp_transaction code: ret=%d |
| lib/arm64-v8a/libcontrol.so | ptp_transaction_new |
| lib/arm64-v8a/libcontrol.so | ptp_transaction: code=%x, transaction_id=%x, get/set: %x, p1: %x, p2: %x, p3: %x. |
| lib/arm64-v8a/libcontrol.so | ptp_unpack_Desc |
| lib/arm64-v8a/libcontrol.so | ptp_wait_event |
| lib/arm64-v8a/libcontrol.so | ptp-camera |
| lib/arm64-v8a/libcontrol.so | ptp.c |
| lib/arm64-v8a/libcontrol.so | ptp2-camera |
| lib/arm64-v8a/libcontrol.so | ptp2/camera_init |
| lib/arm64-v8a/libcontrol.so | ptp2/libptp2/library.c |
| lib/arm64-v8a/libcontrol.so | ptp2/mtpfast: reading mtp proplist of %08x |
| lib/arm64-v8a/libcontrol.so | ptp2/wait_for_event |
| lib/arm64-v8a/libcontrol.so | ptpClient get properties OK |
| lib/arm64-v8a/libcontrol.so | ptpEventRecvThread |
| lib/arm64-v8a/libcontrol.so | ptpevtrecv |
| lib/arm64-v8a/libcontrol.so | ptpevtrecvthread |
| lib/arm64-v8a/libcontrol.so | ptpip |
| lib/arm64-v8a/libcontrol.so | ptpip connected! |
| lib/arm64-v8a/libcontrol.so | ptpip download file(handle) %s |
| lib/arm64-v8a/libcontrol.so | ptpip:%s |
| lib/arm64-v8a/libcontrol.so | ptpip/connect |
| lib/arm64-v8a/libcontrol.so | ptpip/event |
| lib/arm64-v8a/libcontrol.so | ptpip/generic_read |
| lib/arm64-v8a/libcontrol.so | ptpip/getdata |
| lib/arm64-v8a/libcontrol.so | ptpip/init_cmd |
| lib/arm64-v8a/libcontrol.so | ptpip/init_cmd_ack |
| lib/arm64-v8a/libcontrol.so | ptpip/init_event |
| lib/arm64-v8a/libcontrol.so | ptpip/oprequest |
| lib/arm64-v8a/libcontrol.so | ptpip/senddata |
| lib/arm64-v8a/libcontrol.so | ptpReconnect |
| lib/arm64-v8a/libcontrol.so | socket |
| lib/arm64-v8a/libcontrol.so | socket cmd error |
| lib/arm64-v8a/libcontrol.so | socket evt error |
| lib/arm64-v8a/libcontrol.so | socket failed, %d |
| lib/arm64-v8a/libcontrol.so | socket init error |
| lib/arm64-v8a/libcontrol.so | socketIO_Enable |
| lib/arm64-v8a/libcontrol.so | sscanf |
| lib/arm64-v8a/libdepth_net_transport.so | icatch_%s_sdk_%s_%s.log |
| lib/arm64-v8a/libdepth_net_transport.so | sock: %d address: %s |
| lib/arm64-v8a/libdepth_net_transport.so | socket |
| lib/arm64-v8a/libdepth_net_transport.so | socket failed!, error code: %d |
| lib/arm64-v8a/libffmpeg.so | aac bitstream error |
| lib/arm64-v8a/libffmpeg.so | aac_adtstoasc |
| lib/arm64-v8a/libffmpeg.so | aac_coder |
| lib/arm64-v8a/libffmpeg.so | aac_eld |
| lib/arm64-v8a/libffmpeg.so | aac_fixed |
| lib/arm64-v8a/libffmpeg.so | aac_he |
| lib/arm64-v8a/libffmpeg.so | aac_he_v2 |
| lib/arm64-v8a/libffmpeg.so | aac_is |
| lib/arm64-v8a/libffmpeg.so | aac_latm |
| lib/arm64-v8a/libffmpeg.so | aac_ld |
| lib/arm64-v8a/libffmpeg.so | aac_low |
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
| lib/arm64-v8a/libffmpeg.so | h264_metadata |
| lib/arm64-v8a/libffmpeg.so | h264_metadata_bsf |
| lib/arm64-v8a/libffmpeg.so | h264_mode0 |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb bitstream filter required for H.264 streams |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb filter failed to receive output packet |
| lib/arm64-v8a/libffmpeg.so | h264_mp4toannexb filter failed to send input packet |
| lib/arm64-v8a/libffmpeg.so | h264_redundant_pps |
| lib/arm64-v8a/libffmpeg.so | h264_slice_header_init() failed |
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
| lib/arm64-v8a/libffmpegkit.so | sscanf |
| lib/arm64-v8a/libijkffmpeg.so | aac_adtstoasc |
| lib/arm64-v8a/libijkffmpeg.so | aac_latm |
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
| lib/arm64-v8a/libijkffmpeg.so | rtp_read_header(): not enough buffer space for sdp-headers |
| lib/arm64-v8a/libijkffmpeg.so | rtpflags |
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
| lib/arm64-v8a/libpanorama_vr.so | aac_adtstoasc |
| lib/arm64-v8a/libpanorama_vr.so | aac_enc_codec |
| lib/arm64-v8a/libpanorama_vr.so | aac-hbr |
| lib/arm64-v8a/libpanorama_vr.so | h264 b render succeed |
| lib/arm64-v8a/libpanorama_vr.so | h264_AnnexB_NAL_to_avcC |
| lib/arm64-v8a/libpanorama_vr.so | h264_AnnexB_to_AVC |
| lib/arm64-v8a/libpanorama_vr.so | h264_AVC_to_AnnexB |
| lib/arm64-v8a/libpanorama_vr.so | h264_avcC_to_AnnexB_NAL |
| lib/arm64-v8a/libpanorama_vr.so | h264_decode_pps |
| lib/arm64-v8a/libpanorama_vr.so | h264_decode_sps |
| lib/arm64-v8a/libpanorama_vr.so | h264_frame_status_frame |
| lib/arm64-v8a/libpanorama_vr.so | h264_get_picture_size |
| lib/arm64-v8a/libpanorama_vr.so | h264_get_spspps |
| lib/arm64-v8a/libpanorama_vr.so | h264_isavcC |
| lib/arm64-v8a/libpanorama_vr.so | h264_mp4toannexb |
| lib/arm64-v8a/libpanorama_vr.so | h264_release_pps |
| lib/arm64-v8a/libpanorama_vr.so | h264_release_sps |
| lib/arm64-v8a/libpanorama_vr.so | h264_state_config |
| lib/arm64-v8a/libpanorama_vr.so | icatch_ossfix_ffmpeg.log |
| lib/arm64-v8a/libpanorama_vr.so | rtp_extB: frame dropped, prev_idx: %d, frameSize: %d, sink_index: %d, sink_size: %d |
| lib/arm64-v8a/libpanorama_vr.so | rtptime=%u |
| lib/arm64-v8a/libpanorama_vr.so | rtsp client: %p. |
| lib/arm64-v8a/libpanorama_vr.so | rtsp_localIpAddressFromApp |
| lib/arm64-v8a/libpanorama_vr.so | rtsp:// |
| lib/arm64-v8a/libpanorama_vr.so | sock: |
| lib/arm64-v8a/libpanorama_vr.so | socket numbers used in the select() call: |
| lib/arm64-v8a/libpanorama_vr.so | socketpair |
| lib/arm64-v8a/libpanorama_vr.so | sscanf |
| lib/arm64-v8a/libPhoenix_libCodec.so | aac_data.tbl |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacAdifCreate |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacAdifParse |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacAdtsCreate |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacAdtsParse |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacAdtsUpdate |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacBookTbl |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacBrcCheck |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacBrcInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacBrcLimit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacbwbase |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacbwfac |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacbwmult |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacCalcFac |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacCalcFacIdx |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacCfgInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacChnInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacDataInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacDataTable |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacDataTable1 |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacDequantize |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacDesampling |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacExtraInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacFFT |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacFFT0 |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacFFT1 |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacFftReorder |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacFilterBank |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacFilterBankInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffBookEvaluate |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffBookGet |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffBookSelect |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffDecode |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffDecodeFactor |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffEncode |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffEncodeSize |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffEncodeSize book is too big:%d |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffEncodeSize2 |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacHuffInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacIFFT0 |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacIFFT1 |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacIFilterBank |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacIMDCT |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacITDAC |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacMDCT |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacMS |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacPsyInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacQuantize |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacQuantizeInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacRead |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadAdtsHeader |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadCPE |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadGainControlData |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadICSInfo |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadPulseData |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadSCE |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacReadTNSData |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacSampling |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacSampRatioChange |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacSampRatioIndexSet |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacSampRatioSet |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacTDAC |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacTdacMix |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacTdacWin |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacWrite |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacWriteGainControlData |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacWriteInit |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacWriteLTPData |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacWritePredictorData |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacWritePulseData |
| lib/arm64-v8a/libPhoenix_libCodec.so | aacWriteTNSData |
| lib/arm64-v8a/libPhoenix_libCodec.so | h264_mp4toannexb |

_其余 724 条见 natives-strings.tsv_

### rtsp（11 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavformat.so | rtsp:// |
| lib/arm64-v8a/libffmpeg.so | rtsp:// |
| lib/arm64-v8a/libijkffmpeg.so | rtsp:// |
| lib/arm64-v8a/libpanorama_vr.so | rtsp:// |
| lib/armeabi-v7a/libavformat_neon.so | rtsp:// |
| lib/armeabi-v7a/libffmpeg.so | rtsp:// |
| lib/armeabi-v7a/libijkffmpeg.so | rtsp:// |
| lib/armeabi-v7a/libpanorama_vr.so | rtsp:// |
| lib/x86_64/libavformat.so | rtsp:// |
| lib/x86/libavformat.so | rtsp:// |
| lib/x86/libijkffmpeg.so | rtsp:// |

### socketApi（128 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavfilter.so | accept |
| lib/arm64-v8a/libavfilter.so | listen |
| lib/arm64-v8a/libavformat.so | accept |
| lib/arm64-v8a/libavformat.so | connect |
| lib/arm64-v8a/libavformat.so | getsockname |
| lib/arm64-v8a/libavformat.so | inet_ntop |
| lib/arm64-v8a/libavformat.so | inet_pton |
| lib/arm64-v8a/libavformat.so | listen |
| lib/arm64-v8a/libavformat.so | recvfrom |
| lib/arm64-v8a/libavformat.so | sendto |
| lib/arm64-v8a/libavformat.so | setsockopt |
| lib/arm64-v8a/libavformat.so | socket |
| lib/arm64-v8a/libcontrol.so | listen |
| lib/arm64-v8a/libcontrol.so | setsockopt |
| lib/arm64-v8a/libcontrol.so | socket |
| lib/arm64-v8a/libdepth_net_transport.so | setsockopt |
| lib/arm64-v8a/libdepth_net_transport.so | socket |
| lib/arm64-v8a/libffmpeg.so | connect |
| lib/arm64-v8a/libffmpeg.so | getsockname |
| lib/arm64-v8a/libffmpeg.so | listen |
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
| lib/arm64-v8a/libpanorama_vr.so | accept |
| lib/arm64-v8a/libpanorama_vr.so | connect |
| lib/arm64-v8a/libpanorama_vr.so | getsockname |
| lib/arm64-v8a/libpanorama_vr.so | inet_ntop |
| lib/arm64-v8a/libpanorama_vr.so | inet_pton |
| lib/arm64-v8a/libpanorama_vr.so | listen |
| lib/arm64-v8a/libpanorama_vr.so | recvfrom |
| lib/arm64-v8a/libpanorama_vr.so | sendto |
| lib/arm64-v8a/libpanorama_vr.so | setsockopt |
| lib/arm64-v8a/libpanorama_vr.so | socket |
| lib/arm64-v8a/libusb_transport.so | socket |
| lib/armeabi-v7a/libavfilter_neon.so | accept |
| lib/armeabi-v7a/libavfilter_neon.so | listen |
| lib/armeabi-v7a/libavformat_neon.so | accept |
| lib/armeabi-v7a/libavformat_neon.so | connect |
| lib/armeabi-v7a/libavformat_neon.so | getsockname |
| lib/armeabi-v7a/libavformat_neon.so | inet_ntop |
| lib/armeabi-v7a/libavformat_neon.so | inet_pton |
| lib/armeabi-v7a/libavformat_neon.so | listen |
| lib/armeabi-v7a/libavformat_neon.so | recvfrom |
| lib/armeabi-v7a/libavformat_neon.so | sendto |
| lib/armeabi-v7a/libavformat_neon.so | setsockopt |
| lib/armeabi-v7a/libavformat_neon.so | socket |
| lib/armeabi-v7a/libc++_shared.so | socket |
| lib/armeabi-v7a/libcontrol.so | accept |
| lib/armeabi-v7a/libcontrol.so | connect |
| lib/armeabi-v7a/libcontrol.so | getsockname |
| lib/armeabi-v7a/libcontrol.so | listen |
| lib/armeabi-v7a/libcontrol.so | recvfrom |
| lib/armeabi-v7a/libcontrol.so | sendto |
| lib/armeabi-v7a/libcontrol.so | setsockopt |
| lib/armeabi-v7a/libcontrol.so | socket |
| lib/armeabi-v7a/libdepth_net_transport.so | connect |
| lib/armeabi-v7a/libdepth_net_transport.so | setsockopt |
| lib/armeabi-v7a/libdepth_net_transport.so | socket |
| lib/armeabi-v7a/libffmpeg.so | accept |
| lib/armeabi-v7a/libffmpeg.so | connect |
| lib/armeabi-v7a/libffmpeg.so | getsockname |
| lib/armeabi-v7a/libffmpeg.so | listen |
| lib/armeabi-v7a/libffmpeg.so | recvfrom |
| lib/armeabi-v7a/libffmpeg.so | sendto |
| lib/armeabi-v7a/libffmpeg.so | setsockopt |
| lib/armeabi-v7a/libffmpeg.so | socket |
| lib/armeabi-v7a/libijkffmpeg.so | accept |
| lib/armeabi-v7a/libijkffmpeg.so | connect |
| lib/armeabi-v7a/libijkffmpeg.so | getsockname |
| lib/armeabi-v7a/libijkffmpeg.so | inet_ntop |
| lib/armeabi-v7a/libijkffmpeg.so | listen |
| lib/armeabi-v7a/libijkffmpeg.so | recvfrom |
| lib/armeabi-v7a/libijkffmpeg.so | sendto |
| lib/armeabi-v7a/libijkffmpeg.so | setsockopt |
| lib/armeabi-v7a/libijkffmpeg.so | socket |
| lib/armeabi-v7a/libpanorama_vr.so | accept |
| lib/armeabi-v7a/libpanorama_vr.so | connect |
| lib/armeabi-v7a/libpanorama_vr.so | getsockname |
| lib/armeabi-v7a/libpanorama_vr.so | inet_ntop |
| lib/armeabi-v7a/libpanorama_vr.so | inet_pton |
| lib/armeabi-v7a/libpanorama_vr.so | listen |
| lib/armeabi-v7a/libpanorama_vr.so | recvfrom |
| lib/armeabi-v7a/libpanorama_vr.so | sendto |
| lib/armeabi-v7a/libpanorama_vr.so | setsockopt |
| lib/armeabi-v7a/libpanorama_vr.so | socket |
| lib/armeabi-v7a/libusb_transport.so | socket |
| lib/x86_64/libavfilter.so | accept |
| lib/x86_64/libavfilter.so | listen |
| lib/x86_64/libavformat.so | accept |
| lib/x86_64/libavformat.so | connect |
| lib/x86_64/libavformat.so | getsockname |
| lib/x86_64/libavformat.so | inet_ntop |
| lib/x86_64/libavformat.so | inet_pton |
| lib/x86_64/libavformat.so | listen |
| lib/x86_64/libavformat.so | recvfrom |
| lib/x86_64/libavformat.so | sendto |
| lib/x86_64/libavformat.so | setsockopt |
| lib/x86_64/libavformat.so | socket |
| lib/x86/libavfilter.so | accept |
| lib/x86/libavfilter.so | listen |
| lib/x86/libavformat.so | accept |
| lib/x86/libavformat.so | connect |
| lib/x86/libavformat.so | getsockname |
| lib/x86/libavformat.so | inet_ntop |
| lib/x86/libavformat.so | inet_pton |
| lib/x86/libavformat.so | listen |
| lib/x86/libavformat.so | recvfrom |
| lib/x86/libavformat.so | sendto |
| lib/x86/libavformat.so | setsockopt |
| lib/x86/libavformat.so | socket |
| lib/x86/libijkffmpeg.so | accept |
| lib/x86/libijkffmpeg.so | connect |
| lib/x86/libijkffmpeg.so | getsockname |
| lib/x86/libijkffmpeg.so | inet_ntop |
| lib/x86/libijkffmpeg.so | listen |
| lib/x86/libijkffmpeg.so | recvfrom |
| lib/x86/libijkffmpeg.so | sendto |
| lib/x86/libijkffmpeg.so | setsockopt |
| lib/x86/libijkffmpeg.so | socket |

### url（68 条）

| 库 | 字符串 |
|---|---|
| lib/arm64-v8a/libavfilter.so | http://www.w3.org/2000/xmlns/ |
| lib/arm64-v8a/libavfilter.so | http://www.w3.org/XML/1998/namespace |
| lib/arm64-v8a/libavformat.so | http:// |
| lib/arm64-v8a/libavformat.so | http://dashif.org/guidelines/last-segment-number |
| lib/arm64-v8a/libavformat.so | http://www.smpte-ra.org/schemas/2067-3/2013#standard-markers |
| lib/arm64-v8a/libavformat.so | http://www.w3.org/2000/xmlns/ |
| lib/arm64-v8a/libavformat.so | http://www.w3.org/ns/ttml |
| lib/arm64-v8a/libavformat.so | http://www.w3.org/XML/1998/namespace |
| lib/arm64-v8a/libavformat.so | https:// |
| lib/arm64-v8a/libffmpeg.so | http:// |
| lib/arm64-v8a/libijkffmpeg.so | http:// |
| lib/arm64-v8a/libpanorama_vr.so | http:// |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/oauth2/v4/token |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts?id=%s |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts?part=id,snippet,status,contentDetails |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts?part=id,status&id=%s |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts/bind?part=id,contentDetails&id=%s&streamId=%s |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts/transition?broadcastStatus=%s&id=%s&part=id,snippet,contentDetails,status |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveStreams?part=id,snippet,status,cdn&id=%s |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveStreams?part=id,status&id=%s |
| lib/arm64-v8a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveStreams?part=snippet,cdn |
| lib/arm64-v8a/libpanorama_vr.so | https://www.youtube.com/channel/ |
| lib/arm64-v8a/libpanorama_vr.so | https://www.youtube.com/watch?v= |
| lib/arm64-v8a/libusb_transport.so | http://libusb.info |
| lib/armeabi-v7a/libavfilter_neon.so | http://www.w3.org/2000/xmlns/ |
| lib/armeabi-v7a/libavfilter_neon.so | http://www.w3.org/XML/1998/namespace |
| lib/armeabi-v7a/libavformat_neon.so | http:// |
| lib/armeabi-v7a/libavformat_neon.so | http://dashif.org/guidelines/last-segment-number |
| lib/armeabi-v7a/libavformat_neon.so | http://www.smpte-ra.org/schemas/2067-3/2013#standard-markers |
| lib/armeabi-v7a/libavformat_neon.so | http://www.w3.org/2000/xmlns/ |
| lib/armeabi-v7a/libavformat_neon.so | http://www.w3.org/ns/ttml |
| lib/armeabi-v7a/libavformat_neon.so | http://www.w3.org/XML/1998/namespace |
| lib/armeabi-v7a/libavformat_neon.so | https:// |
| lib/armeabi-v7a/libffmpeg.so | http:// |
| lib/armeabi-v7a/libijkffmpeg.so | http:// |
| lib/armeabi-v7a/libpanorama_vr.so | http:// |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/oauth2/v4/token |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts?id=%s |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts?part=id,snippet,status,contentDetails |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts?part=id,status&id=%s |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts/bind?part=id,contentDetails&id=%s&streamId=%s |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveBroadcasts/transition?broadcastStatus=%s&id=%s&part=id,snippet,contentDetails,status |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveStreams?part=id,snippet,status,cdn&id=%s |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveStreams?part=id,status&id=%s |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.googleapis.com/youtube/v3/liveStreams?part=snippet,cdn |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.youtube.com/channel/ |
| lib/armeabi-v7a/libpanorama_vr.so | https://www.youtube.com/watch?v= |
| lib/armeabi-v7a/libusb_transport.so | http://libusb.info |
| lib/x86_64/libavfilter.so | http://www.w3.org/2000/xmlns/ |
| lib/x86_64/libavfilter.so | http://www.w3.org/XML/1998/namespace |
| lib/x86_64/libavformat.so | http:// |
| lib/x86_64/libavformat.so | http://dashif.org/guidelines/last-segment-number |
| lib/x86_64/libavformat.so | http://www.smpte-ra.org/schemas/2067-3/2013#standard-markers |
| lib/x86_64/libavformat.so | http://www.w3.org/2000/xmlns/ |
| lib/x86_64/libavformat.so | http://www.w3.org/ns/ttml |
| lib/x86_64/libavformat.so | http://www.w3.org/XML/1998/namespace |
| lib/x86_64/libavformat.so | https:// |
| lib/x86/libavfilter.so | http://www.w3.org/2000/xmlns/ |
| lib/x86/libavfilter.so | http://www.w3.org/XML/1998/namespace |
| lib/x86/libavformat.so | http:// |
| lib/x86/libavformat.so | http://dashif.org/guidelines/last-segment-number |
| lib/x86/libavformat.so | http://www.smpte-ra.org/schemas/2067-3/2013#standard-markers |
| lib/x86/libavformat.so | http://www.w3.org/2000/xmlns/ |
| lib/x86/libavformat.so | http://www.w3.org/ns/ttml |
| lib/x86/libavformat.so | http://www.w3.org/XML/1998/namespace |
| lib/x86/libavformat.so | https:// |
| lib/x86/libijkffmpeg.so | http:// |
| lib/x86/libijkffmpeg.so | https:// |
