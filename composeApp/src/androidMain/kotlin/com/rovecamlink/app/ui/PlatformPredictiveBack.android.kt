package com.rovecamlink.app.ui

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.activity.compose.PredictiveBackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * Android's predictive back, straight from activity-compose.
 *
 * The callback contract is the stream's own: it runs when a gesture starts, the flow yields the
 * finger's progress, a *completed* flow means the user let go past the threshold, and the
 * coroutine being cancelled means they took it back. That is why the commit sits after the
 * collection rather than behind a threshold of ours — Android already ran that decision, and
 * disagreeing with it is how a gesture ends up settling the wrong way.
 */
@Composable
actual fun PlatformPredictiveBackHandler(
    enabled: Boolean,
    onProgress: suspend (Flow<Float>) -> Unit,
    onCommit: suspend () -> Unit,
    onCancel: suspend () -> Unit,
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        PredictiveBackHandler(enabled = enabled) { events ->
            try {
                onProgress(events.map { it.progress })
                onCommit()
            } catch (cancelled: CancellationException) {
                onCancel()
                throw cancelled
            }
        }
    } else {
        // Below 33 there is no gesture to report progress for, and the predictive API has no
        // stream to hand over. The press is the whole gesture then, and the settle plays out from
        // rest through the same spring — which is what makes the three-button bar on an older
        // phone behave exactly like a tapped back arrow.
        val scope = rememberCoroutineScope()
        BackHandler(enabled = enabled) { scope.launch { onCommit() } }
    }
}
