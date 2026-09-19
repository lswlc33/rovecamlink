package com.rovecamlink.app

import android.app.Application
import android.content.Context

/**
 * Application entry point. Holds a global [Context] so the KMP `actual`
 * factories (WiFi, storage, permissions) can be created without threading a
 * Context through the shared commonMain code.
 */
class RoveCamApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}

internal val androidContext: Context
    get() = RoveCamApp.appContext
