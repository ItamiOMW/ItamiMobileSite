package com.itami.itami_mobile.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import com.itami.itami_mobile.components.widgets.button.IconButton
import com.itami.itami_mobile.theme.brand
import com.itami.itami_mobile.theme.fonts.LabelLargeTextStyle
import com.itami.itami_mobile.theme.fonts.TextStyle
import com.itami.itami_mobile.theme.icons.IconStyle
import com.itami.itami_mobile.theme.text
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.colors.shifted
import org.jetbrains.compose.web.css.*

val SideMenuStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxHeight()
            .width(33.percent)
            .padding(top = 1.cssRem, leftRight = 1.cssRem)
            .gap(1.5.cssRem)
            .backgroundColor(colorPalette.overlay)
            .borderRadius(topRight = 30.px, bottomRight = 30.px)
    }
    Breakpoint.ZERO {
        Modifier.width(50.percent)
    }
    Breakpoint.SM {
        Modifier.width(43.percent)
    }
    Breakpoint.MD {
        Modifier.width(30.percent)
    }
}

val SideMenuSlideInAnim by Keyframes {
    from {
        Modifier.translate((-100).percent)
    }

    to {
        Modifier.translateX(0.percent)
    }
}

enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}

@Composable
fun SideMenu(
    menuState: SideMenuState,
    selectedSectionId: String,
    onCloseRequest: () -> Unit,
    onAnimationEnd: () -> Unit,
) {
    Overlay(
        modifier = Modifier
            .zIndex(2)
            .setVariable(OverlayVars.BackgroundColor, Colors.Transparent)
            .onClick { onCloseRequest() },
        contentAlignment = Alignment.CenterStart
    ) {
        key(menuState) {
            Column(
                SideMenuStyle.toModifier()
                    .animation(
                        SideMenuSlideInAnim.toAnimation(
                            duration = 200.ms,
                            timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                            fillMode = AnimationFillMode.Forwards
                        )
                    )
                    .onAnimationEnd { onAnimationEnd() }
                    .onClick { it.stopPropagation() },
                horizontalAlignment = Alignment.Start
            ) {
                IconButton(onClick = { onCloseRequest() }) {
                    CloseIcon(modifier = IconStyle.toModifier())
                }
                Column(
                    modifier = Modifier
                        .padding(right = 0.75.cssRem)
                        .gap(1.5.cssRem),
                    horizontalAlignment = Alignment.Start
                ) {
                    Section.entries.forEach { section ->
                        SideMenuNavLink(
                            href = section.href,
                            text = section.text,
                            selected = section.id == selectedSectionId
                        )
                    }
                }
            }
        }
    }
}


val SideMenuLinkVariant by LinkStyle.addVariant(extraModifiers = {
    TextStyle.toModifier(LabelLargeTextStyle)
}) {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .textDecorationLine(TextDecorationLine.None)
            .color(colorPalette.text.primary)
    }
    hover {
        Modifier.color(colorPalette.brand.primary)
    }
    active {
        Modifier.color(colorPalette.brand.primary.shifted(colorMode, 0.15f))
    }
}

val ActiveSideMenuLinkVariant by LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier.color(colorPalette.brand.primary)
    }
    hover {
        Modifier
    }
    active {
        Modifier
    }
}

@Composable
private fun SideMenuNavLink(
    href: String,
    text: String,
    selected: Boolean,
) {
    Link(
        path = href,
        text = text,
        variant = SideMenuLinkVariant.thenIf(selected, ActiveSideMenuLinkVariant)
    )
}