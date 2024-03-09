package com.itami.itami_mobile.components.sections.works

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.sections.works.components.WorkItem
import com.itami.itami_mobile.components.sections.works.components.WorkItemsGridStyle
import com.itami.itami_mobile.components.widgets.section.SectionContainer
import com.itami.itami_mobile.theme.fonts.*
import com.itami.itami_mobile.utils.Res
import com.itami.itami_mobile.utils.Section
import com.itami.itami_mobile.utils.Work
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun WorksSection() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        modifier = Modifier,
        section = Section.Works,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextContent(breakpoint = breakpoint)
        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, lg = 3),
            modifier = WorkItemsGridStyle.toModifier()
        ) {
            Work.entries.forEach {
                WorkItem(
                    work = it,
                    modifier = Modifier.flex(1)
                )
            }
            MoreIsYetToCome()
        }
    }
}

@Composable
private fun MoreIsYetToCome() {
    val colorPalette = ColorMode.current.toPalette()
    Box(
        modifier = Modifier
            .backgroundColor(colorPalette.overlay)
            .borderRadius(30.px),
        contentAlignment = Alignment.Center
    ) {
        SpanText(
            text = "More is yet to come...",
            modifier = TextStyle.toModifier(TitleTextStyle)
        )
    }
}

@Composable
private fun TextContent(
    breakpoint: Breakpoint,
) {
    Column(
        modifier = Modifier.margin(top = 8.5.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor).textAlign(TextAlign.Center),
            text = Res.Strings.WORKS_SECTION_TITLE
        )
        SpanText(
            modifier = TextStyle.toModifier(SubDisplayTextStyle, TextStyleSecondaryColor)
                .maxWidth(if (breakpoint >= Breakpoint.SM) 75.percent else 100.percent)
                .margin(top = 1.cssRem)
                .textAlign(TextAlign.Center),
            text = Res.Strings.WORKS_SECTION_SUBTITLE
        )
    }
}