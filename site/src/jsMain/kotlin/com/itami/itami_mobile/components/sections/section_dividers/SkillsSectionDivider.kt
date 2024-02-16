package com.itami.itami_mobile.components.sections.section_dividers

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.skill.SkillItem
import com.itami.itami_mobile.utils.Skill
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*

val SkillSectionDividerStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .padding(topBottom = 3.43.cssRem)
            .background(colorPalette.overlay)
            .flexWrap(FlexWrap.Wrap)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .gap(48.px)
    }
    Breakpoint.ZERO {
        Modifier
            .gap(12.px)
            .padding(left = 1.5.cssRem, top = 3.43.cssRem, bottom = 3.43.cssRem)
    }
    Breakpoint.SM {
        Modifier.gap(24.px)
    }
}

@Composable
fun SkillsSectionDivider(
    skillsToDisplay: List<Skill> = listOf(Skill.AndroidStudio, Skill.Kotlin, Skill.Ktor, Skill.Figma),
    modifier: Modifier = Modifier,
) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = SkillSectionDividerStyle.toModifier().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        skillsToDisplay.forEach { skill ->
            SkillItem(
                skill = skill,
                modifier = Modifier.flexBasis(if (breakpoint >= Breakpoint.MD) 25.percent else 50.percent),
                horizontalArrangement = if (breakpoint >= Breakpoint.MD) Arrangement.Center else Arrangement.Start
            )
        }
    }
}