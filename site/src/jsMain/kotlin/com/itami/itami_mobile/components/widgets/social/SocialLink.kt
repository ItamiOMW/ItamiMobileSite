package com.itami.itami_mobile.components.widgets.social

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.utils.Social
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier

val SocialLinkStyle by ComponentStyle {
    hover {
        Modifier.scale(1.1)
    }
}

@Composable
fun SocialLink(
    social: Social,
    modifier: Modifier = Modifier,
    openLinksStrategy: OpenLinkStrategy = OpenLinkStrategy.IN_NEW_TAB
) {
    Link(
        modifier = SocialLinkStyle.toModifier().then(modifier),
        path = social.link,
        openExternalLinksStrategy = openLinksStrategy,
        openInternalLinksStrategy = openLinksStrategy
    ) {
        social.content()
    }
}