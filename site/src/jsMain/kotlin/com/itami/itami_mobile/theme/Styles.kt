package com.itami.itami_mobile.theme

import com.itami.itami_mobile.utils.Res
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.breakpoint.BreakpointSizes
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.modifyComponentStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@InitSilk
fun initAppStyles(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        registerStyleBase("body") {
            Modifier.fontFamily(Res.FontFamilies.POPPINS_REGULAR, Res.FontFamilies.POPPINS_MEDIUM)
        }
    }
    ctx.theme.apply {
        breakpoints = BreakpointSizes(
            sm = 30.cssRem, // 480 px,
            md = 48.cssRem, // 768 px
            lg = 76.cssRem, // 1216 px
            xl = 94.cssRem, // 1504 px
        )
        modifyComponentStyle(ButtonStyle) {
            base {
                Modifier.borderRadius(30.px)
            }
        }
        modifyComponentStyle(LinkStyle) {
            val colorPalette = colorMode.toPalette()
            base {
                Modifier
                    .textDecorationLine(TextDecorationLine.None)
                    .color(colorPalette.text.primary)
            }
        }
    }
}

val IconStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.color)
    }
    Breakpoint.ZERO {
        Modifier.size(1.55.cssRem)
    }
    Breakpoint.SM {
        Modifier.size(1.55.cssRem)
    }
    Breakpoint.MD {
        Modifier.size(1.65.cssRem)
    }
    Breakpoint.LG {
        Modifier.size(1.65.cssRem)
    }
    Breakpoint.XL {
        Modifier.size(1.75.cssRem)
    }
}