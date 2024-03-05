package com.itami.itami_mobile.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.itami.itami_mobile.components.sections.footer.Footer
import com.itami.itami_mobile.components.sections.nav_header.NavHeader
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import kotlinx.browser.document

@Composable
fun DefaultPageLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    LaunchedEffect(title) {
        document.title = "Itami Mobile - $title"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavHeader()
        content()
        Footer()
    }
}