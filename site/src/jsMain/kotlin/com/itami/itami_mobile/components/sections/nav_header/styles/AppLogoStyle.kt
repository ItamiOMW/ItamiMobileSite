package com.itami.itami_mobile.components.sections.nav_header.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem

val AppLogoStyle by ComponentStyle {
    base {
        Modifier.display(DisplayStyle.Flex)
    }
    Breakpoint.ZERO {
        Modifier.height(1.625.cssRem)
    }
    Breakpoint.SM {
        Modifier.height(1.75.cssRem)
    }
    Breakpoint.MD {
        Modifier.height(1.8.cssRem)
    }
    Breakpoint.LG {
        Modifier.height(1.85.cssRem)
    }
    Breakpoint.XL {
        Modifier.height(2.125.cssRem)
    }
}