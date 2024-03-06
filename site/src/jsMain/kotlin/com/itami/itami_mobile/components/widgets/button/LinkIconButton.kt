package com.itami.itami_mobile.components.widgets.button

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.theme.icons.IconStyle
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.style.active
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier

val LinkIconButtonVariant by LinkStyle.addVariant {
    base {
        Modifier.transition(CSSTransition("0.15s"))
    }
    hover {
        Modifier.scale(1.1)
    }
    active {
        Modifier.scale(1.2)
    }
}

@Composable
fun LinkIconButton(
    path: String,
    modifier: Modifier = Modifier,
    tooltipText: String? = null,
    onClick: (() -> Unit)? = null,
    icon: @Composable () -> Unit,
    openLinkStrategy: OpenLinkStrategy = OpenLinkStrategy.IN_NEW_TAB
) {
    Link(
        path = path,
        openExternalLinksStrategy = openLinkStrategy,
        openInternalLinksStrategy = openLinkStrategy,
        variant = LinkIconButtonVariant,
        modifier = modifier.onClick { onClick?.invoke() },
    ) {
        icon()
        if (tooltipText != null) {
            Tooltip(
                target = ElementTarget.PreviousSibling,
                text = tooltipText
            )
        }
    }
}

@Composable
fun LinkIconButton(
    path: String,
    iconRes: String,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = IconStyle.toModifier(),
    tooltipText: String? = null,
    onClick: (() -> Unit)? = null,
    openLinkStrategy: OpenLinkStrategy = OpenLinkStrategy.IN_NEW_TAB
) {
    Link(
        path = path,
        openExternalLinksStrategy = openLinkStrategy,
        openInternalLinksStrategy = openLinkStrategy,
        variant = LinkIconButtonVariant,
        modifier = modifier.onClick { onClick?.invoke() },
    ) {
        Image(
            modifier = iconModifier,
            src = iconRes
        )
        if (tooltipText != null) {
            Tooltip(
                target = ElementTarget.PreviousSibling,
                text = tooltipText
            )
        }
    }
}