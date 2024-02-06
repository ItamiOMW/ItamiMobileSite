package com.itami.itami_mobile.pages

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.layouts.DefaultPageLayout
import com.itami.itami_mobile.theme.text
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    val colorPalette = ColorMode.current.toPalette()
    DefaultPageLayout(title = "Home") {
        Section(
            attrs = {
                id(Section.Start.id)
                style {
                    fontSize(56.px)
                    height(1000.px)
                    width(100.vw)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                }
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Start")
            }
        }
        Section(
            attrs = {
                id(Section.About.id)
                style {
                    fontSize(56.px)
                    height(1000.px)
                    width(100.vw)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                }
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("About")
            }
        }
        Section(
            attrs = {
                id(Section.Works.id)
                style {
                    fontSize(56.px)
                    height(1000.px)
                    width(100.vw)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                }
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Works")
            }
        }
        Section(
            attrs = {
                id(Section.Contact.id)
                style {
                    fontSize(56.px)
                    height(1000.px)
                    width(100.vw)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                }
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Contact me")
            }
        }
    }
}
