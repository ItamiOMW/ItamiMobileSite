package com.itami.itami_mobile.components.sections.nav_header.styles

import com.itami.itami_mobile.theme.Fonts
import com.itami.itami_mobile.theme.brand
import com.itami.itami_mobile.theme.siteFont
import com.itami.itami_mobile.theme.text
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.active
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val SideMenuStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxHeight()
            .width(33.percent)
            .padding(top = 1.cssRem, leftRight = 1.cssRem)
            .gap(1.5.cssRem)
            .backgroundColor(colorPalette.overlay)
            .borderRadius(topRight = 30.px, bottomRight = 30.px)
    }
    Breakpoint.ZERO {
        Modifier.width(50.percent)
    }
    Breakpoint.SM {
        Modifier.width(43.percent)
    }
    Breakpoint.MD {
        Modifier.width(30.percent)
    }
}

val SideMenuSlideInAnim by Keyframes {
    from {
        Modifier.translate((-100).percent)
    }

    to {
        Modifier.translateX(0.percent)
    }
}

val SideMenuLinkVariant by LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .color(colorPalette.text.primary)
    }
    hover {
        Modifier.color(colorPalette.brand.primary)
    }
    active {
        Modifier.color(colorPalette.brand.primary.shifted(colorMode, 0.15f))
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
}

val ActiveSideMenuLinkVariant by LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.primary)
    }
    hover {
        Modifier
    }
    active {
        Modifier
    }
}