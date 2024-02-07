package com.itami.itami_mobile.components.sections.nav_header

import androidx.compose.runtime.*
import com.itami.itami_mobile.components.sections.nav_header.styles.*
import com.itami.itami_mobile.components.widgets.button.IconButton
import com.itami.itami_mobile.components.widgets.button.PrimaryIconButton
import com.itami.itami_mobile.theme.DarkModeIcon
import com.itami.itami_mobile.theme.HamburgerIcon
import com.itami.itami_mobile.theme.IconStyle
import com.itami.itami_mobile.theme.LightModeIcon
import com.itami.itami_mobile.utils.Res
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.thenIf
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.asList

@Composable
fun NavHeader() {
    var colorMode by ColorMode.currentState

    val sections = document.getElementsByClassName("section-box").asList()
    var selectedSectionId by remember { mutableStateOf(Section.Start.id) }

    LaunchedEffect(selectedSectionId) {
        window.history.replaceState(null, "", "#$selectedSectionId")
    }

    window.onscroll = { _ ->
        sections.forEach { section ->
            val positionInfo = section.getBoundingClientRect()
            val top = window.scrollY
            val offset = positionInfo.top + top - 200 // Don't know why, but that's the only way it works ¯\_(@_@)_/¯
            val height = positionInfo.height
            val id = section.id

            if (top >= offset && top < offset + height) {
                selectedSectionId = id
            }
        }
    }

    Header(
        attrs = NavHeaderStyle.toAttrs()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .displayUntil(Breakpoint.LG),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var sideMenuState by remember { mutableStateOf(SideMenuState.CLOSED) }
            if (sideMenuState != SideMenuState.CLOSED) {
                SideMenu(
                    menuState = sideMenuState,
                    selectedSectionId = selectedSectionId,
                    onCloseRequest = { sideMenuState = sideMenuState.close() },
                    onAnimationEnd = {
                        if (sideMenuState == SideMenuState.CLOSING) {
                            sideMenuState = SideMenuState.CLOSED
                        }
                    }
                )
            }
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterStart) {
                IconButton(
                    modifier = Modifier.padding(0.25.cssRem),
                    onClick = { sideMenuState = SideMenuState.OPEN }
                ) {
                    HamburgerIcon(modifier = IconStyle.toModifier().size(36.px))
                }
            }
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.Center) {
                AppLogo(colorMode = colorMode)
            }
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterEnd) {
                ThemeIconButton(
                    colorMode = colorMode,
                    onClick = { colorMode = colorMode.opposite }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .displayIfAtLeast(Breakpoint.LG),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterStart) {
                AppLogo(colorMode = colorMode)
            }
            NavBar(selectedSectionId = selectedSectionId)
            Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterEnd) {
                ThemeIconButton(
                    colorMode = colorMode,
                    onClick = { colorMode = colorMode.opposite }
                )
            }
        }
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
private fun SideMenu(
    menuState: SideMenuState,
    selectedSectionId: String,
    onCloseRequest: () -> Unit,
    onAnimationEnd: () -> Unit,
) {
    Overlay(
        modifier = Modifier
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

@Composable
private fun ThemeIconButton(
    colorMode: ColorMode = ColorMode.current,
    onClick: () -> Unit,
) {
    PrimaryIconButton(
        onClick = {
            onClick()
        },
    ) {
        when (colorMode) {
            ColorMode.LIGHT -> LightModeIcon(modifier = IconStyle.toModifier(ThemeIconVariant))
            ColorMode.DARK -> DarkModeIcon(modifier = IconStyle.toModifier(ThemeIconVariant))
        }
    }
}

@Composable
private fun NavBar(
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

@Composable
private fun AppLogo(
    colorMode: ColorMode,
) {
    Anchor(href = "/") {
        Img(
            src = when (colorMode) {
                ColorMode.LIGHT -> Res.Images.LOGO_LIGHT
                ColorMode.DARK -> Res.Images.LOGO_DARK
            },
            attrs = AppLogoStyle.toAttrs()
        )
    }
}