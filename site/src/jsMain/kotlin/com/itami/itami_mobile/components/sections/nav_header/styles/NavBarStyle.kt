package com.itami.itami_mobile.components.sections.nav_header.styles

import com.itami.itami_mobile.theme.Fonts
import com.itami.itami_mobile.theme.brand
import com.itami.itami_mobile.theme.siteFont
import com.itami.itami_mobile.theme.text
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.active
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.*

val NavBarStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .size(autoLength)
            .background(colorPalette.overlay)
            .borderRadius(30.px)
            .listStyle(ListStyleType.None)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .flex(1)
    }
}

val NavBarLinkVariant by LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        val fontsDefault = Fonts[Breakpoint.XL]
        Modifier
            .alignContent(AlignContent.Center)
            .color(colorPalette.text.primary)
            .background(colorPalette.overlay)
            .borderRadius(r = 30.px)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition("0.2s"))
            .font { siteFont(fontsDefault.labelLarge) }
    }
    hover {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.1f))
    }
    active {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.15f))
    }
    Breakpoint.LG {
        val fontsLG = Fonts[Breakpoint.LG]
        Modifier
            .font { siteFont(fontsLG.labelMedium) }
            .size(width = 13.5.em, height = 3.8.em)
    }
    Breakpoint.XL {
        val fontsXL = Fonts[Breakpoint.XL]
        Modifier
            .font { siteFont(fontsXL.labelMedium) }
            .size(width = 14.em, height = 4.em)
    }
}

val ActiveNavBarLinkVariant by LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .color(colorPalette.brand.onPrimary)
            .background(colorPalette.brand.primary)
            .transition(CSSTransition("0.1s"))
    }
    hover {
        Modifier.background(colorPalette.brand.primary)
    }
}