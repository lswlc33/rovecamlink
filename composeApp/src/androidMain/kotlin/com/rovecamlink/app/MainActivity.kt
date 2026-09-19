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
    private var launcher: ((Array<String>) -> Unit)? = null
    private var pending: ((Boolean) -> Unit)? = null

    fun attach(l: (Array<String>) -> Unit) { launcher = l }
    fun detach() { launcher = null }

    fun onResult(allGranted: Boolean) {
        pending?.invoke(allGranted)
        pending = null
    }

    suspend fun request(permissions: Array<String>): Boolean {
        val l = launcher ?: return false
        // Drop already-granted ones.
        val needed = permissions.filterNot { isGranted(it) }.toTypedArray()
        if (needed.isEmpty()) return true
        return suspendCancellableCoroutine { cont ->
            pending = { granted -> if (cont.isActive) cont.resume(granted) }
            try {
                l(needed)
            } catch (t: Throwable) {
                pending = null
                if (cont.isActive) cont.resume(false)
            }
        }
    }

    private fun isGranted(p: String): Boolean =
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
            App()
        }
    }

    override fun onDestroy() {
        PermissionBridge.detach()
        super.onDestroy()
    }
}
