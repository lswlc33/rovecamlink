package com.rovecamlink.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/** Bridges runtime-permission requests from shared code to the hosting Activity. */
object PermissionBridge {
    private val lock = Any()
    private var launcher: ((Array<String>) -> Unit)? = null

    /**
     * One dialog at a time, and everyone who asked gets an answer.
     *
     * This used to hold a single `pending` callback, so two concurrent callers — the
     * Bluetooth path asking for `BLUETOOTH_CONNECT` while the Wi-Fi path asks for
     * `NEARBY_WIFI_DEVICES`, which is exactly what a tap on the connect card does —
     * overwrote each other and the loser suspended for the rest of the session with no
     * dialog left on screen to wake it up.
     */
    private val waiting = ArrayDeque<Waiter>()
    private var inFlight: Waiter? = null

    private class Waiter(val permissions: Array<String>, val deliver: (Boolean) -> Unit)

    fun attach(l: (Array<String>) -> Unit) {
        val restart = synchronized(lock) { launcher = l; inFlight.also { inFlight = null } }
        // A request made before the Activity existed (or after it came back) can only
        // be answered once a launcher exists again.
        restart?.let { deliver(it, granted = false) }
    }

    fun detach() {
        val stranded = synchronized(lock) {
            launcher = null
            val all = listOfNotNull(inFlight) + waiting.toList()
            inFlight = null
            waiting.clear()
            all
        }
        // Nobody will answer these: the Activity is gone. Fail them rather than let the
        // caller's connect flow hang.
        stranded.forEach { deliver(it, granted = false) }
    }

    fun onResult(allGranted: Boolean) {
        val done = synchronized(lock) { inFlight.also { inFlight = null } }
        if (done != null) deliver(done, allGranted)
        startNext()
    }

    suspend fun request(permissions: Array<String>): Boolean {
        // Drop already-granted ones.
        val needed = permissions.filterNot { isGranted(it) }.toTypedArray()
        if (needed.isEmpty()) return true
        val l = synchronized(lock) { launcher } ?: return false
        return kotlinx.coroutines.suspendCancellableCoroutine { cont ->
            val waiter = Waiter(needed) { granted -> if (cont.isActive) cont.resume(granted) }
            cont.invokeOnCancellation {
                synchronized(lock) {
                    waiting.remove(waiter)
                    if (inFlight === waiter) inFlight = null
                }
            }
            val launchNow = synchronized(lock) {
                if (inFlight == null) {
                    inFlight = waiter
                    true
                } else {
                    waiting.addLast(waiter)
                    false
                }
            }
            if (launchNow) try { l(needed) } catch (t: Throwable) {
                deliver(waiter, false)
                synchronized(lock) { if (inFlight === waiter) inFlight = null }
                startNext()
            }
        }
    }

    private fun startNext() {
        val l = synchronized(lock) { launcher } ?: return
        val next = synchronized(lock) {
            if (inFlight != null) return
            waiting.removeFirstOrNull()?.also { inFlight = it }
        } ?: return
        try {
            l(next.permissions)
        } catch (t: Throwable) {
            deliver(next, false)
            synchronized(lock) { if (inFlight === next) inFlight = null }
            startNext()
        }
    }

    private fun deliver(waiter: Waiter, granted: Boolean) = waiter.deliver(granted)

    fun isGranted(p: String): Boolean =
        androidx.core.content.ContextCompat.checkSelfPermission(
            RoveCamApp.appContext, p,
        ) == android.content.pm.PackageManager.PERMISSION_GRANTED
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val requestPermissions = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions(),
        ) { result -> PermissionBridge.onResult(result.values.all { it }) }

        PermissionBridge.attach { perms -> requestPermissions.launch(perms) }

        setContent {
            com.rovecamlink.app.ui.theme.RoveMiuixTheme {
                App()
            }
        }
    }

    override fun onDestroy() {
        PermissionBridge.detach()
        super.onDestroy()
    }
}
