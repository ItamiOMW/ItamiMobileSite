package com.itami.itami_mobile.components.sections.about

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.section.SectionContainer
import com.itami.itami_mobile.theme.fonts.DisplayTextStyle
import com.itami.itami_mobile.theme.fonts.TextStyle
import com.itami.itami_mobile.theme.fonts.TextStylePrimaryColor
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px


@Composable
fun AboutSection() {
    SectionContainer(
        modifier = Modifier.padding(topBottom = 134.px),
        section = Section.About,
        verticalArrangement = Arrangement.Top,
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                .textAlign(TextAlign.Center),
            text = Section.About.text
        )
    }
}