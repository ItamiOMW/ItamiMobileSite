package com.itami.itami_mobile.components.sections.start

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.sections.start.components.GradientCircleStyle
import com.itami.itami_mobile.components.sections.start.components.StartSectionGridStyle
import com.itami.itami_mobile.components.sections.start.components.StartSectionImageStyle
import com.itami.itami_mobile.components.widgets.button.PrimaryButton
import com.itami.itami_mobile.components.widgets.section.SectionContainer
import com.itami.itami_mobile.theme.fonts.*
import com.itami.itami_mobile.theme.icons.ArrowForwardIcon
import com.itami.itami_mobile.theme.icons.IconOnBrandColorVariant
import com.itami.itami_mobile.theme.icons.IconStyle
import com.itami.itami_mobile.theme.icons.ScrollMouseIcon
import com.itami.itami_mobile.utils.Res
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div

@Composable
fun StartSection() {
    val pageContext = rememberPageContext()
    val breakpoint = rememberBreakpoint()

    SectionContainer(
        modifier = GradientCircleStyle.toModifier()
            .height(75.vh)
            .minHeight(600.px),
        section = Section.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Div(
            attrs = StartSectionGridStyle.toAttrs()
        ) {
            TextContent(
                breakpoint = breakpoint,
                onExploreWorksClicked = { pageContext.router.navigateTo(Section.Works.href) }
            )
            ImageContent()
        }
        ScrollHint(modifier = Modifier.displayIfAtLeast(Breakpoint.MD).align(Alignment.Start))
    }
}

@Composable
private fun ScrollHint(
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        ScrollMouseIcon(
            modifier = IconStyle.toModifier()
                .size(36.px)
        )
        SpanText(
            modifier = TextStyle.toModifier(LabelMediumTextStyle, TextStylePrimaryColor)
                .textAlign(TextAlign.Start),
            text = Res.Strings.SCROLL_HINT
        )
    }
}

@Composable
private fun TextContent(
    breakpoint: Breakpoint,
    onExploreWorksClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.flex(1),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = if (breakpoint >= Breakpoint.LG) Alignment.Start else Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                .textAlign(if (breakpoint > Breakpoint.MD) TextAlign.Start else TextAlign.Center),
            text = Res.Strings.START_SECTION_TITLE
        )
        SpanText(
            modifier = TextStyle.toModifier(SubDisplayTextStyle, TextStyleSecondaryColor)
                .maxWidth(if (breakpoint >= Breakpoint.SM) 75.percent else 100.percent)
                .margin(top = 3.px)
                .textAlign(if (breakpoint > Breakpoint.MD) TextAlign.Start else TextAlign.Center),
            text = Res.Strings.START_SECTION_SUBTITLE
        )
        PrimaryButton(
            modifier = Modifier.margin(top = 50.px),
            text = Res.Strings.START_SECTION_BUTTON_TEXT,
            icon = {
                ArrowForwardIcon(modifier = IconStyle.toModifier(IconOnBrandColorVariant))
            },
            onClick = {
                onExploreWorksClicked()
            }
        )
    }
}

@Composable
private fun ImageContent() {
    Box(
        modifier = Modifier.flex(1),
        contentAlignment = Alignment.Center
    ) {
        Image(
            src = Res.Images.START_IMAGE,
            modifier = StartSectionImageStyle.toModifier()
        )
    }
}