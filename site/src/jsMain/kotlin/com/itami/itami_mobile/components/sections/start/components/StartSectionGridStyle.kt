package com.itami.itami_mobile.components.sections.start.components

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*

val StartSectionGridKeyFrames by Keyframes {
    0.percent {
        Modifier
            .margin(right = 50.px)
            .opacity(0)
    }
    100.percent {
        Modifier
            .margin(right = 0.px)
            .opacity(1)
    }
}

val StartSectionGridStyle by ComponentStyle(extraModifiers = {
    Modifier.animation(
        StartSectionGridKeyFrames.toAnimation(
            duration = 0.5.s,
            timingFunction = AnimationTimingFunction.EaseInOut
        )
    )
}) {
    base {
        Modifier
            .width(100.percent)
            .display(DisplayStyle.Flex)
            .gap(50.px)
    }
    Breakpoint.ZERO {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.SM {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.MD {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.LG {
        Modifier.flexDirection(FlexDirection.Row)
    }
    Breakpoint.XL {
        Modifier.flexDirection(FlexDirection.Row)
    }
}