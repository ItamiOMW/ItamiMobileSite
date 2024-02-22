package com.itami.itami_mobile.theme.icons

import com.itami.itami_mobile.theme.brand
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem

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

val IconBrandColorVariant by IconStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.primary)
    }
}

val IconOnBrandColorVariant by IconStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.onPrimary)
    }
}

val LargeIconSize by IconStyle.addVariant {
    Breakpoint.ZERO {
        Modifier.size(1.8.cssRem)
    }
    Breakpoint.SM {
        Modifier.size(2.2.cssRem)
    }
    Breakpoint.MD {
        Modifier.size(2.5.cssRem)
    }
    Breakpoint.LG {
        Modifier.size(2.8.cssRem)
    }
    Breakpoint.XL {
        Modifier.size(3.cssRem)
    }
}