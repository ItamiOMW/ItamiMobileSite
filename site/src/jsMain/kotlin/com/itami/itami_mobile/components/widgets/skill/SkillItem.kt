package com.itami.itami_mobile.components.widgets.skill

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.theme.fonts.*
import com.itami.itami_mobile.utils.Skill
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

val SkillItemStyle by ComponentStyle(extraModifiers = { TextStyle.toModifier(LabelLargeTextStyle) }) {
    base {
        Modifier.maxWidth(12.5.em)
    }
}

val SkillItemImageVariant by ImageStyle.addVariant {
    Breakpoint.ZERO {
        Modifier.size(24.px)
    }
    Breakpoint.SM {
        Modifier.size(28.px)
    }
    Breakpoint.MD {
        Modifier.size(32.px)
    }
    Breakpoint.LG {
        Modifier.size(36.px)
    }
    Breakpoint.XL {
        Modifier.size(36.px)
    }
}

@Composable
fun SkillItem(
    skill: Skill,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = SkillItemStyle.toModifier().then(modifier),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            src = skill.iconRes,
            variant = SkillItemImageVariant,
        )
        Column(
            modifier = Modifier.margin(left = 12.px),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = skill.skillName,
                modifier = TextStyle.toModifier(LabelLargeTextStyle, TextStylePrimaryColor)
            )
            SpanText(
                text = skill.experience,
                modifier = TextStyle.toModifier(BodySmallTextStyle, TextStyleSecondaryColor)
            )
        }
    }
}