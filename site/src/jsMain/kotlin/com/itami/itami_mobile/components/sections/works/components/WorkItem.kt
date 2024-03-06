package com.itami.itami_mobile.components.sections.works.components

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.button.LinkIconButton
import com.itami.itami_mobile.theme.fonts.BodyLargeTextStyle
import com.itami.itami_mobile.theme.fonts.TextStyle
import com.itami.itami_mobile.theme.fonts.TitleTextStyle
import com.itami.itami_mobile.theme.icons.ExternalLinkIcon
import com.itami.itami_mobile.theme.icons.IconStyle
import com.itami.itami_mobile.theme.icons.LargeIconSize
import com.itami.itami_mobile.utils.Work
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.before
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*

val WorkItemStyle by ComponentStyle {
    base {
        Modifier
            .position(Position.Relative)
            .borderRadius(30.px)
            .overflow(Overflow.Hidden)
    }
    before {
        Modifier
            .content("")
            .backgroundColor(Color.rgb(r = 29, g = 28, b = 38))
            .opacity(0.75)
            .position(Position.Absolute)
            .fillMaxWidth()
            .height(0.px)
            .transition(CSSTransition("ease-in-out", 0.4.s))
    }
    (hover + before) {
        Modifier.fillMaxHeight()
    }
    cssRule(":hover .work-item-overlay") {
        Modifier
            .top(50.percent)
            .opacity(1)
    }
}

val WorkItemImageStyle by ComponentStyle {
    base {
        Modifier.fillMaxSize()
    }
}

val WorkItemOverlayStyle by ComponentStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .textAlign(TextAlign.Center)
            .top(65.percent)
            .left(50.percent)
            .translate((-50).percent, (-50).percent)
            .transition(CSSTransition("ease-in-out", 0.5.s))
            .opacity(0)
            .fillMaxWidth()
            .color(Colors.White)
    }
}

@Composable
fun WorkItem(
    work: Work,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = WorkItemStyle.toModifier().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Image(
            src = work.imageRes,
            modifier = WorkItemImageStyle.toModifier()
        )
        Column(
            modifier = WorkItemOverlayStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                text = work.workName,
                modifier = TextStyle.toModifier(TitleTextStyle)
            )
            SpanText(
                text = work.description,
                modifier = TextStyle.toModifier(BodyLargeTextStyle).margin(top = 0.5.cssRem)
            )
            LinkIconButton(
                modifier = Modifier.margin(top = 1.cssRem),
                path = work.link,
                icon = { ExternalLinkIcon(modifier = IconStyle.toModifier(LargeIconSize).color(Colors.White)) }
            )
        }
    }
}