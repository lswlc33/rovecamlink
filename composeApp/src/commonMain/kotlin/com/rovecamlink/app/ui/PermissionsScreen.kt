package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.log_close
import com.rovecamlink.app.permission_bluetooth_body
import com.rovecamlink.app.permission_bluetooth_title
import com.rovecamlink.app.permission_camera_body
import com.rovecamlink.app.permission_camera_title
import com.rovecamlink.app.permission_locate_body
import com.rovecamlink.app.permission_locate_title
import com.rovecamlink.app.permission_storage_body
import com.rovecamlink.app.permission_storage_title
import com.rovecamlink.app.permission_title
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * What each permission is for, in the app rather than only in the system dialog.
 *
 * The house rule is that a greyed-out control has to say why (2026-09 决定), and a
 * refused permission is the same thing one level down: the camera list goes quiet, the
 * Bluetooth section reports 不支持, and the only place that explains the connection is
 * the OS prompt the user already dismissed. This page is that explanation, kept in-app
 * so it is reachable after the fact.
 *
 * Bodies name what stops working, not what the permission is called — a user deciding
 * whether to grant 位置 wants to know it is the camera list that goes empty.
 */
@Composable
fun PermissionsScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val locateTitle = stringResource(Res.string.permission_locate_title)
    val locateBody = stringResource(Res.string.permission_locate_body)
    val bluetoothTitle = stringResource(Res.string.permission_bluetooth_title)
    val bluetoothBody = stringResource(Res.string.permission_bluetooth_body)
    val storageTitle = stringResource(Res.string.permission_storage_title)
    val storageBody = stringResource(Res.string.permission_storage_body)
    val cameraTitle = stringResource(Res.string.permission_camera_title)
    val cameraBody = stringResource(Res.string.permission_camera_body)

    MiuixPage(
        title = stringResource(Res.string.permission_title),
        outerPadding = outerPadding,
        state = state,
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(
                    MiuixIcons.Back,
                    contentDescription = stringResource(Res.string.log_close),
                    tint = scheme.onSurface,
                )
            }
        },
    ) {
        section(title = locateTitle) { hintLine(locateBody) }
        section(title = bluetoothTitle) { hintLine(bluetoothBody) }
        section(title = storageTitle) { hintLine(storageBody) }
        section(title = cameraTitle) { hintLine(cameraBody) }
    }
}
