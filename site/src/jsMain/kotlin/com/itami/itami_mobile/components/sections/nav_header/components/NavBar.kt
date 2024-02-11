package com.itami.itami_mobile.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.theme.brand
import com.itami.itami_mobile.theme.fonts.*
import com.itami.itami_mobile.theme.text
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text

val NavBarStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .size(autoLength)
            .background(colorPalette.overlay)
            .borderRadius(30.px)
            .listStyle(ListStyleType.None)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .flex(1)
    }
}

@Composable
fun NavBar(
    selectedSectionId: String
) {
    Nav(
        attrs = NavBarStyle.toAttrs()
    ) {
        Section.entries.forEach { section ->
            NavBarLink(
                href = section.href,
                text = section.text,
                selected = section.id == selectedSectionId
            )
        }
    }
}


val NavBarLinkVariant by LinkStyle.addVariant(extraModifiers = {
    TextStyle.toModifier(LabelMediumTextStyle)
}) {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .alignContent(AlignContent.Center)
            .color(colorPalette.text.primary)
            .background(colorPalette.overlay)
            .borderRadius(r = 30.px)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition("0.2s"))
    }
    hover {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.1f))
    }
    active {
        Modifier.background(colorPalette.overlay.shifted(colorMode, 0.15f))
    }
    Breakpoint.LG {
        Modifier.size(width = 13.5.em, height = 3.8.em)
    }
    Breakpoint.XL {
        Modifier.size(width = 13.8.em, height = 3.9.em)
    }
}

val ActiveNavBarLinkVariant by LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .color(colorPalette.brand.onPrimary)
            .background(colorPalette.brand.primary)
            .transition(CSSTransition("0.1s"))
    }
    hover {
        Modifier.background(colorPalette.brand.primary)
    }
}

@Composable
private fun NavBarLink(
    href: String,
    text: String,
    selected: Boolean,
) {
    Link(
        path = href,
        variant = NavBarLinkVariant.thenIf(selected, ActiveNavBarLinkVariant),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text)
        }
    }
}