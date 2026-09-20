package com.rovecamlink.app

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

/**
 * 本地化文本的载体。AppState 等非 Composable 层无法直接调用 [stringResource],
 * 因此先发出 [Res] / [Raw],再在 UI 层调用 [resolve] 时按当前 locale 渲染。
 *
 * - [Res] 走 Compose Multiplatform 资源表(values / values-zh/strings.xml)
 *   中的本地化模板,带可选格式参数(对应 `%1$s`、`%2$d` 等)。
 * - [Raw] 是动态/异常文本(协议层下发的 CmdResult.Failure.message、
 *   Throwable.message),这些文本来自外部数据,无法本地化,原样显示。
 */
sealed interface LocalizedString {
    data class Res(
        val resource: StringResource,
        val args: List<Any> = emptyList(),
    ) : LocalizedString

    data class Raw(val text: String) : LocalizedString
}

/** 构造一条本地化的状态/错误消息。 */
fun localized(resource: StringResource, vararg args: Any): LocalizedString =
    LocalizedString.Res(resource, args.toList())

/** 构造一条不可本地化(动态来源)的文本,如异常 message。 */
fun raw(text: String): LocalizedString = LocalizedString.Raw(text)

/** 在 Composable 中按当前 locale 渲染 [LocalizedString];null 视为空串。 */
@Composable
fun LocalizedString?.resolve(): String = when (this) {
    is LocalizedString.Res -> stringResource(resource, *args.toTypedArray())
    is LocalizedString.Raw -> text
    null -> ""
}
