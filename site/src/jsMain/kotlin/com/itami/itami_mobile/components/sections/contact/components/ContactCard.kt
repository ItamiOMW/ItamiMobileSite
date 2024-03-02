package com.itami.itami_mobile.components.sections.contact.components

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.widgets.social.SocialLink
import com.itami.itami_mobile.theme.fonts.*
import com.itami.itami_mobile.utils.Res
import com.itami.itami_mobile.utils.Social
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val ContactCardStyle by ComponentStyle {
    val colors = colorMode.toPalette()
    base {
        Modifier
            .fillMaxWidth()
            .background(colors.overlay)
            .borderRadius(30.px)
            .padding(topBottom = 1.cssRem, leftRight = 1.cssRem)
    }
    Breakpoint.LG {
        Modifier
            .fillMaxWidth(65.percent)
            .padding(topBottom = 2.cssRem, leftRight = 2.cssRem)
    }
    Breakpoint.XL {
        Modifier
            .fillMaxWidth(60.percent)
            .maxWidth(64.cssRem)
            .padding(topBottom = 2.25.cssRem, leftRight = 2.25.cssRem)
    }
}

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = ContactCardStyle.toModifier().then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                .textAlign(TextAlign.Center),
            text = Res.Strings.CONTACT_SECTION_TITLE
        )
        P(
            attrs = TextStyle.toModifier(BodyLargeTextStyle, TextStyleSecondaryColor)
                .textAlign(TextAlign.Center)
                .margin(top = 0.6.em, leftRight = 0.6.em)
                .toAttrs(),
        ) {
            Text("If you have any questions, don't hesitate to contact me via email at ")
            SpanText(
                text = Res.Strings.EMAIL_ADDRESS,
                modifier = TextStyle.toModifier(BodyLargeTextStyle, TextStylePrimaryColor)
                    .fontFamily(Res.FontFamilies.POPPINS_MEDIUM)
                    .textAlign(TextAlign.Center),
            )
            Text(" or text me on Telegram at ")
            SpanText(
                text = Res.Strings.TELEGRAM_USERNAME,
                modifier = TextStyle.toModifier(BodyLargeTextStyle, TextStylePrimaryColor)
                    .fontFamily(Res.FontFamilies.POPPINS_MEDIUM)
                    .textAlign(TextAlign.Center),
            )
        }
        Row(
            modifier = Modifier
                .margin(top = 4.3.em)
                .gap(1.5.em),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Social.entries.forEach { social ->
                SocialLink(social = social)
            }
        }
    }
}