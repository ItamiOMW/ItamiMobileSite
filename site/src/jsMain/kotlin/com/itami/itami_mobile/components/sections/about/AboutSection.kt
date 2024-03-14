package com.itami.itami_mobile.components.sections.about

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.section.SectionContainer
import com.itami.itami_mobile.components.widgets.section.SectionContainerStyle
import com.itami.itami_mobile.components.widgets.skill.SkillItem
import com.itami.itami_mobile.components.widgets.skill.components.AboutSectionSkillsGridVariant
import com.itami.itami_mobile.theme.brand
import com.itami.itami_mobile.theme.fonts.*
import com.itami.itami_mobile.utils.Res
import com.itami.itami_mobile.utils.Section
import com.itami.itami_mobile.utils.Skill
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh

val AboutSectionVariant by SectionContainerStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.minHeight(100.vh)
    }
    Breakpoint.ZERO {
        Modifier
            .maxWidth(100.percent)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = if (colorMode.isDark) 0.1f else 0.2f))
                    add(Colors.Transparent, 50.percent)
                }
            )
    }
    Breakpoint.SM {
        Modifier.maxWidth(100.percent)
    }
    Breakpoint.MD {
        Modifier
            .maxWidth(90.percent)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 50.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = if (colorMode.isDark) 0.1f else 0.2f))
                    add(Colors.Transparent, 63.percent)
                }
            )
    }
    Breakpoint.LG {
        Modifier.maxWidth(80.percent)
    }
    Breakpoint.XL {
        Modifier.maxWidth(70.percent)
    }
}

@Composable
fun AboutSection() {
    SectionContainer(
        modifier = Modifier,
        variant = AboutSectionVariant,
        section = Section.About,
        verticalArrangement = Arrangement.Center,
    ) {
        TextContent()
        SimpleGrid(
            variant = AboutSectionSkillsGridVariant,
            numColumns = numColumns(base = 2, md = 5, lg = 5)
        ) {
            Skill.entries.forEach { skill ->
                SkillItem(
                    skill = skill,
                    modifier = Modifier.flexGrow(1)
                )
            }
        }
    }
}

@Composable
private fun TextContent() {
    Column(
        modifier = Modifier
            .padding(top = 8.5.cssRem)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                .textAlign(TextAlign.Center),
            text = Res.Strings.ABOUT_SECTION_TITLE
        )
        SpanText(
            modifier = TextStyle.toModifier(SubDisplayTextStyle, TextStyleSecondaryColor)
                .padding(top = 1.cssRem)
                .textAlign(TextAlign.Center),
            text = Res.Strings.ABOUT_SECTION_SUBTITLE
        )
    }
}