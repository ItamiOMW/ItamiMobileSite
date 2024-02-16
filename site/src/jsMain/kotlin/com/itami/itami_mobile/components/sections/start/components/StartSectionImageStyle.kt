package com.itami.itami_mobile.components.sections.start.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

val StartSectionImageStyle by ComponentStyle {
    Breakpoint.ZERO {
        Modifier.height(222.px)
    }
    Breakpoint.SM {
        Modifier.height(264.px)
    }
    Breakpoint.MD {
        Modifier.height(333.px)
    }
    Breakpoint.LG {
        Modifier.height(443.px)
    }
    Breakpoint.XL {
        Modifier.height(500.px)
    }
}