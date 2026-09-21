package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.transport.CameraHttp

// iOS has no self-update path (the App Store owns distribution).
actual suspend fun applyAppUpdate(info: AppUpdateInfo, http: CameraHttp): String? =
    "Version v${info.version} available — update from the App Store"