package com.rovecamlink.app.core.prefs

/**
 * Desktop keeps the values for the life of the process. The desktop build exists to run
 * the camera simulator and eyeball the UI; bookkeeping that outlives the window is not
 * something it is asked to prove.
 */
actual fun createAppPrefs(): AppPrefs = MemoryAppPrefs()
