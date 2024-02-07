package com.itami.itami_mobile.pages

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.layouts.DefaultPageLayout
import com.itami.itami_mobile.theme.text
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    val colorPalette = ColorMode.current.toPalette()
    DefaultPageLayout(title = "Home") {
        Box(
            modifier = Modifier
                .attrsModifier {
                    id(Section.Start.id)
                    classes("section-box")
                }
                .styleModifier {
                    height(1000.px)
                    width(100.vw)
                    fontSize(56.px)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                },
            contentAlignment = Alignment.Center
        ) {
            Text("Start")
        }
        Box(
            modifier = Modifier
                .attrsModifier {
                    id(Section.Works.id)
                    classes("section-box")
                }
                .styleModifier {
                    height(1000.px)
                    width(100.vw)
                    fontSize(56.px)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                },
            contentAlignment = Alignment.Center
        ) {
            Text("Works")
        }
        Box(
            modifier = Modifier
                .attrsModifier {
                    id(Section.About.id)
                    classes("section-box")
                }
                .styleModifier {
                    height(1000.px)
                    width(100.vw)
                    fontSize(56.px)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                },
            contentAlignment = Alignment.Center
        ) {
            Text("About")
        }
        Box(
            modifier = Modifier
                .attrsModifier {
                    id(Section.Contact.id)
                    classes("section-box")
                }
                .styleModifier {
                    height(1000.px)
                    width(100.vw)
                    fontSize(56.px)
                    backgroundColor(colorPalette.background)
                    color(colorPalette.text.primary)
                },
            contentAlignment = Alignment.Center
        ) {
            Text("Contact")
        }
    }
}
