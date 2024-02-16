package com.itami.itami_mobile.components.sections.start.components

import com.itami.itami_mobile.theme.brand
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.percent

val GradientCircleStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    Breakpoint.ZERO {
        Modifier
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 35.percent)
                }
            )
    }
    Breakpoint.SM {
        Modifier
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 40.percent)
                }
            )
    }
    Breakpoint.MD {
        Modifier
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 45.percent)
                }
            )
    }
    Breakpoint.LG {
        Modifier
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 71.5.percent, y = 50.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 35.percent)
                }
            )
    }
    Breakpoint.XL {
        Modifier
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 71.5.percent, y = 50.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 30.percent)
                }
            )
    }
}