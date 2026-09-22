package com.rovecamlink.app

import android.app.Application
import android.content.Context
import com.rovecamlink.app.core.log.installCrashRecorder

/**
 * Application entry point. Holds a global [Context] so the KMP `actual`
 * factories (WiFi, storage, permissions) can be created without threading a
 * Context through the shared commonMain code.
 */
class RoveCamApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        // Before anything that can throw: a crash with no trace in the exported log is
        // how the 2026-09-22 live-view crash cost a full field session to find.
        installCrashRecorder()
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}

internal val androidContext: Context
    get() = RoveCamApp.appContext
