package com.itami.itami_mobile.components.sections.about.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridAutoRows
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGridStyle
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr

val AboutSectionSkillsGridVariant by SimpleGridStyle.addVariant {
    base {
        Modifier
            .fillMaxWidth()
            .padding(top = 6.5.cssRem, left = 2.25.cssRem)
            .gridAutoRows { size(1.fr) }
    }
    Breakpoint.ZERO {
        Modifier.gap(
            columnGap = 1.cssRem,
            rowGap = 1.5.cssRem
        )
    }
    Breakpoint.LG {
        Modifier.gap(
            columnGap = 1.5.cssRem,
            rowGap = 2.5.cssRem
        )
    }
}