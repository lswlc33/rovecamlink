# TUWIN — native 方法（JNI 导出符号）全量

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 共 43 个；命名规则 `Java_<包>_<类>_<方法>`，下划线即包名里的点，反解后即 Java 声明

---

| 库 | JNI 符号 |
|---|---|
| lib/arm64-v8a/libdatastore_shared_counter.so | Java_androidx_datastore_core_NativeSharedCounter_nativeTruncateFile |
| lib/arm64-v8a/libdatastore_shared_counter.so | Java_androidx_datastore_core_NativeSharedCounter_nativeCreateSharedCounter |
| lib/arm64-v8a/libdatastore_shared_counter.so | Java_androidx_datastore_core_NativeSharedCounter_nativeGetCounterValue |
| lib/arm64-v8a/libdatastore_shared_counter.so | Java_androidx_datastore_core_NativeSharedCounter_nativeIncrementAndGetCounterValue |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naPlay |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naStopSaveVideo |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naInitAndPlay |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetDecodeFrame |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSaveVideo |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetPosition |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naTranscodeAviToMp4 |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetFrameCnt |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetVideoRes |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetStreaming |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetStreamCodecID |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSeek |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naExtractFrame |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetup |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetTransCodeOptions |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naCancelTranscode |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetDebugMessage |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naStatus |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naPause |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naResume |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetBufferingTime |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetRepeat |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetScaleMode |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetDuration |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetVideoInfo |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naStop |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetZoomInRatio |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetDecodeOptions |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetRevSizeCnt |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naDrawFrame |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetEncodeByLocalTime |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetForceToTranscode |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSetCovertDecodeFrameFormat |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naGetTranscodeProgress |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naInitDrawFrame |
| lib/arm64-v8a/libffmpeg.so | Java_com_generalplus_ffmpegLib_ffmpegWrapper_naSaveSnapshot |
| lib/arm64-v8a/libumeng-spy.so | Java_com_umeng_umzid_Spy_getNativeTag |
| lib/arm64-v8a/libumeng-spy.so | Java_com_umeng_umzid_Spy_getNativeLibraryVersion |
| lib/arm64-v8a/libumeng-spy.so | Java_com_umeng_umzid_Spy_getNativeID |
