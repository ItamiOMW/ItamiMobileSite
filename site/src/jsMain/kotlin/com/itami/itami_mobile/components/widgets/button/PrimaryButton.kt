package com.itami.itami_mobile.components.widgets.button

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.itami.itami_mobile.theme.brand
import com.itami.itami_mobile.theme.fonts.LabelLargeTextStyle
import com.itami.itami_mobile.theme.fonts.TextStyle
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.thenIf
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

val PrimaryButtonVariant by ButtonStyle.addVariant(extraModifiers = {
    TextStyle.toModifier(LabelLargeTextStyle)
}) {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .width(auto)
            .height(auto)
            .background(colorPalette.brand.primary)
            .color(colorPalette.brand.onPrimary)
            .padding(leftRight = 2.25.em, topBottom = 1.1.em)
    }
}

val PrimaryButtonWithIconPadding by ButtonStyle.addVariant {
    base {
        Modifier.padding(left = 2.25.em, right = 2.em, top = 1.em, bottom = 1.em)
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: (@Composable () -> Unit)? = null,
    onClick: (SyntheticMouseEvent) -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        variant = PrimaryButtonVariant.thenIf(icon != null, PrimaryButtonWithIconPadding),
    ) {
        Row(
            modifier = Modifier.gap(12.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text)
            icon?.invoke()
        }
    }
}