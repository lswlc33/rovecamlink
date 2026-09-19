# RoveCamLink

An open-source, Android-first action-camera companion app built with **Kotlin Multiplatform + Compose Multiplatform + Compose Cupertino**. It connects to action cameras over Wi-Fi direct, shows a live RTSP preview, and transfers files — with a pluggable protocol layer so new cameras/brands can be added without rewriting the app.

> The stock vendor apps are laggy. RoveCamLink aims to be clean, fast, and extensible.

## First supported device

**XTU X7 Pro** — Hisilicon Hi35xx (`hi3510`) HTTP CGI protocol, discovered automatically at runtime by probing each registered protocol (no hardcoded model table).

## Architecture

```
composeApp/
  commonMain/   shared UI (Compose Cupertino), state, protocols, transport
    core/model      data models (session, status, settings, files, events)
    core/transport  Ktor HTTP client (text/bytes/resumable download)
    core/protocol   CameraProtocol interface + registry (plugin point)
    core/net        runtime device discovery / identification
    core/wifi       Wi-Fi controller + scanner (expect/actual)
    core/storage    file saver + permissions (expect/actual)
    core/media      live preview view (expect/actual)
    brand/xtu       Hisilicon hi3510 CGI plugin
    brand/tuwin     TUWIN REST plugin
  androidMain/  Wi-Fi direct, Media3 RTSP preview, MediaStore saving
  desktopMain/  desktop entry (connect to the simulator via Manual IP)
  iosMain/      iOS scaffold (compiles; not functionally verified)
simulator/      Ktor desktop server emulating the Hisilicon CGI protocol
```

**Adding a new camera:** implement `CameraProtocol`, register it in `AppGraph`. Discovery probes every registered protocol, so a new device works without touching the UI.

## Build & run

Requirements: JDK 17, Android SDK (compileSdk 34). Set `sdk.dir` in `local.properties`.

```bash
# Android debug APK
./gradlew :composeApp:assembleDebug
# -> composeApp/build/outputs/apk/debug/composeApp-debug.apk

# Desktop camera simulator (then connect from the app via Manual IP -> 10.0.2.2:8080 on emulator, or your LAN IP)
./gradlew :simulator:run

# Desktop app
./gradlew :composeApp:run
```

### iOS

The iOS app is a shell that hosts the shared Compose UI. It compiles but has not been functionally verified (no device available). Generate the Xcode project with [XcodeGen](https://github.com/yonaskolb/XcodeGen):

```bash
cd iosApp && xcodegen generate && open RoveCamLink.xcodeproj
```

## Testing without a camera

Run the simulator, then in the app use **Manual connect** and enter the simulator's `host:port`. The simulator implements the full `hi3510` CGI surface (device attributes, status, battery, SD, work modes, capture/record, file list, thumbnails, and file downloads), so connect → live status → file list → download all work end to end.

## Status

- [x] Extensible protocol-plugin architecture
- [x] XTU X7 Pro (Hisilicon CGI) + runtime auto-detect
- [x] Wi-Fi direct connect (Android API 24+ / 29+ paths)
- [x] RTSP live preview (Media3, Android)
- [x] File transfer (list / thumbnail / resumable download / publish to gallery)
- [x] Compose Cupertino UI
- [x] Desktop camera simulator
- [x] Installable debug APK
- [ ] iOS functional verification (scaffold only)
