package com.itami.itami_mobile.components.sections.contact

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.sections.contact.components.ContactCard
import com.itami.itami_mobile.components.widgets.section.SectionContainer
import com.itami.itami_mobile.components.widgets.section.SectionContainerStyle
import com.itami.itami_mobile.utils.Section
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.components.style.addVariant
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val ContactSectionVariant by SectionContainerStyle.addVariant {
    base {
        Modifier
            .height(90.vh)
            .minHeight(600.px)
    }
}

@Composable
fun ContactSection() {
    SectionContainer(
        variant = ContactSectionVariant,
        section = Section.Contact,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactCard()
    }
}