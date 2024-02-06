package com.itami.itami_mobile.components.sections.nav_header.styles

import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*

val NavHeaderStyle by ComponentStyle(extraModifiers = { SmoothColorStyle.toModifier() }) {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
            .position(Position.Sticky)
            .top(0.percent)
            .backdropFilter(saturate(180.percent), blur(5.px))
            .boxShadow(spreadRadius = 2.px, color = colorPalette.overlay)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.SpaceBetween)
            .alignItems(AlignItems.Center)
    }

    Breakpoint.ZERO {
        Modifier.padding(left = 12.px, right = 12.px, top = 6.px, bottom = 6.px)
    }

    Breakpoint.SM {
        Modifier.padding(left = 24.px, right = 24.px, top = 10.px, bottom = 10.px)
    }

    Breakpoint.MD {
        Modifier.padding(left = 34.px, right = 34.px, top = 15.px, bottom = 15.px)
    }

    Breakpoint.LG {
        Modifier.padding(left = 54.px, right = 54.px, top = 20.px, bottom = 20.px)
    }

    Breakpoint.XL {
        Modifier.padding(left = 104.px, right = 104.px, top = 20.px, bottom = 20.px)
    }
}