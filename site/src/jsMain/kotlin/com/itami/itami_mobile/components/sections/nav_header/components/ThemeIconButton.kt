package com.itami.itami_mobile.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.button.PrimaryIconButton
import com.itami.itami_mobile.theme.DarkModeIcon
import com.itami.itami_mobile.theme.IconStyle
import com.itami.itami_mobile.theme.LightModeIcon
import com.itami.itami_mobile.theme.brand
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette

val ThemeIconVariant by IconStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.onPrimary)
    }
}

@Composable
fun ThemeIconButton(
    colorMode: ColorMode = ColorMode.current,
    onClick: () -> Unit,
) {
    PrimaryIconButton(
        onClick = {
            onClick()
        },
    ) {
        when (colorMode) {
            ColorMode.LIGHT -> LightModeIcon(modifier = IconStyle.toModifier(ThemeIconVariant))
            ColorMode.DARK -> DarkModeIcon(modifier = IconStyle.toModifier(ThemeIconVariant))
        }
    }
}