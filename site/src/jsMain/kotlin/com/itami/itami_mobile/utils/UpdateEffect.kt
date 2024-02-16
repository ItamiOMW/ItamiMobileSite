package com.itami.itami_mobile.utils

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope

/**
 * The same as [LaunchedEffect], but skips first invocation.
 *
 * Thanks to https://stackoverflow.com/a/76057975
 */
@Composable
fun UpdateEffect(key: Any, block: suspend CoroutineScope.() -> Unit) {
    var isTriggered by remember { mutableStateOf(false) }

    LaunchedEffect(key) {
        if (isTriggered) {
            block()
        } else {
            isTriggered = true
        }
    }
}