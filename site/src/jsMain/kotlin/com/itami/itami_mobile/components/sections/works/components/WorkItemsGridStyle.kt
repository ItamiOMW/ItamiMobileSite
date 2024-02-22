package com.itami.itami_mobile.components.sections.works.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val WorkItemsGridStyle by ComponentStyle {
    base {
        Modifier
            .gap(2.cssRem)
            .margin(top = 4.75.cssRem)
    }
    Breakpoint.ZERO {
        Modifier.padding(leftRight = 16.px)
    }
    Breakpoint.SM {
        Modifier.padding(leftRight = 28.px)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 48.px)
    }
    Breakpoint.LG {
        Modifier.padding(leftRight = 94.px)
    }
    Breakpoint.XL {
        Modifier.padding(leftRight = 134.px)
    }
}