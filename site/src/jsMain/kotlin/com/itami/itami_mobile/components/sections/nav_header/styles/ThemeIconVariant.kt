package com.itami.itami_mobile.components.sections.nav_header.styles

import com.itami.itami_mobile.theme.IconStyle
import com.itami.itami_mobile.theme.brand
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette

val ThemeIconVariant by IconStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.onPrimary)
    }
}