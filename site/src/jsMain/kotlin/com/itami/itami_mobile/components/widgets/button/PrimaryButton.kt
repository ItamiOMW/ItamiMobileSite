package com.itami.itami_mobile.components.widgets.button

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.itami.itami_mobile.theme.Fonts
import com.itami.itami_mobile.theme.brand
import com.itami.itami_mobile.theme.siteFont
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.thenIf
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

val PrimaryButtonVariant by ButtonStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .width(auto)
            .height(auto)
            .background(colorPalette.brand.primary)
            .color(colorPalette.brand.onPrimary)
            .padding(leftRight = 2.25.cssRem, topBottom = 1.1.cssRem)
    }
    Breakpoint.ZERO {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelLarge) }
    }
    Breakpoint.SM {
        val fontsSM = Fonts[Breakpoint.SM]
        Modifier.font { siteFont(fontsSM.labelLarge) }
    }
    Breakpoint.MD {
        val fontsMD = Fonts[Breakpoint.MD]
        Modifier.font { siteFont(fontsMD.labelLarge) }
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier.font { siteFont(fontsLG.labelLarge) }
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier.font { siteFont(fontsXL.labelLarge) }
    }
}

val PrimaryButtonWithIconPadding by ButtonStyle.addVariant {
    base {
        Modifier.padding(left = 2.25.cssRem, right = 2.cssRem, top = 1.cssRem, bottom = 1.cssRem)
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: (@Composable () -> Unit)? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        variant = PrimaryButtonVariant.thenIf(icon != null, PrimaryButtonWithIconPadding),
    ) {
        Row(
            modifier = Modifier.gap(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text)
            icon?.invoke()
        }
    }
}