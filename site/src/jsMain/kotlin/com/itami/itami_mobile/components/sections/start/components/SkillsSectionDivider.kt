package com.itami.itami_mobile.components.sections.start.components

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.skill.SkillItem
import com.itami.itami_mobile.models.Skill
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh

val SkillSectionDividerStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .background(colorPalette.overlay)
    }
    Breakpoint.ZERO {
        Modifier
            .padding(top = 2.5.cssRem, bottom = 2.5.cssRem)
            .height(18.vh)
    }
    Breakpoint.SM {
        Modifier
            .height(15.vh)
            .padding(topBottom = 3.cssRem)
    }
    Breakpoint.MD {
        Modifier.padding(topBottom = 3.4.cssRem)
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
        SimpleGrid(
            modifier = Modifier
                .gap(if (breakpoint >= Breakpoint.MD) 1.5.cssRem else 1.cssRem)
                .padding(left = if (breakpoint <= Breakpoint.SM) 2.25.cssRem else 0.cssRem),
            numColumns = numColumns(base = 2, sm = 4, md = 4)
        ) {
            skillsToDisplay.forEach { skill ->
                SkillItem(
                    skill = skill,
                    modifier = Modifier.flexGrow(1),
                    horizontalArrangement = if (breakpoint >= Breakpoint.MD) Arrangement.Center else Arrangement.Start
                )
            }
        }
    }
}