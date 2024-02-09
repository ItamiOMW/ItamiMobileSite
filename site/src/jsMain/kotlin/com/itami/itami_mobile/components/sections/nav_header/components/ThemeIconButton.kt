package com.itami.itami_mobile.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.button.PrimaryIconButton
import com.itami.itami_mobile.theme.icons.DarkModeIcon
import com.itami.itami_mobile.theme.icons.LightModeIcon
import com.itami.itami_mobile.theme.icons.IconStyle
import com.itami.itami_mobile.theme.icons.OnPrimaryIconVariant
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode

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
        val iconModifier = IconStyle.toModifier(OnPrimaryIconVariant)
        when (colorMode) {
            ColorMode.LIGHT -> LightModeIcon(modifier = iconModifier)
            ColorMode.DARK -> DarkModeIcon(modifier = iconModifier)
        }
    }
}