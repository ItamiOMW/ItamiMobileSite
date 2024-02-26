package com.itami.itami_mobile.components.sections.works.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem

val WorkItemsGridStyle by ComponentStyle {
    base {
        Modifier
            .gap(2.cssRem)
            .margin(top = 4.75.cssRem)
    }
    Breakpoint.ZERO {
        Modifier
            .gap(1.cssRem)
            .margin(top = 3.cssRem)
    }
    Breakpoint.SM {
        Modifier
            .gap(1.25.cssRem)
            .margin(top = 3.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .gap(1.5.cssRem)
            .margin(top = 3.5.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .gap(2.cssRem)
            .margin(top = 4.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .gap(2.cssRem)
            .margin(top = 4.5.cssRem)
    }
}