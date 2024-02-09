package com.itami.itami_mobile.components.sections.nav_header

import androidx.compose.runtime.*
import com.itami.itami_mobile.components.sections.nav_header.components.*
import com.itami.itami_mobile.components.widgets.button.IconButton
import com.itami.itami_mobile.theme.icons.HamburgerIcon
import com.itami.itami_mobile.theme.icons.IconStyle
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Header
import org.w3c.dom.asList

val NavHeaderStyle by ComponentStyle(extraModifiers = { SmoothColorStyle.toModifier() }) {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
            .position(Position.Sticky)
            .top(0.percent)
            .backdropFilter(saturate(180.percent), blur(5.px))
            .boxShadow(spreadRadius = 2.px, color = colorPalette.overlay)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.SpaceBetween)
            .alignItems(AlignItems.Center)
    }

    Breakpoint.ZERO {
        Modifier.padding(left = 12.px, right = 12.px, top = 6.px, bottom = 6.px)
    }

    Breakpoint.SM {
        Modifier.padding(left = 24.px, right = 24.px, top = 10.px, bottom = 10.px)
    }

    Breakpoint.MD {
        Modifier.padding(left = 34.px, right = 34.px, top = 15.px, bottom = 15.px)
    }

    Breakpoint.LG {
        Modifier.padding(left = 54.px, right = 54.px, top = 20.px, bottom = 20.px)
    }

    Breakpoint.XL {
        Modifier.padding(left = 104.px, right = 104.px, top = 20.px, bottom = 20.px)
    }
}

@Composable
fun NavHeader() {
    var colorMode by ColorMode.currentState

    val sections = document.getElementsByClassName("section-container").asList()
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