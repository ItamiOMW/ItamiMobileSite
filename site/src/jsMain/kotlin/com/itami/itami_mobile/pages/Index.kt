package com.itami.itami_mobile.pages

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.components.layouts.DefaultPageLayout
import com.itami.itami_mobile.components.sections.about.AboutSection
import com.itami.itami_mobile.components.sections.contact.ContactSection
import com.itami.itami_mobile.components.sections.section_dividers.SkillsSectionDivider
import com.itami.itami_mobile.components.sections.start.StartSection
import com.itami.itami_mobile.components.sections.works.WorksSection
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    DefaultPageLayout(title = "Home") {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StartSection()
            SkillsSectionDivider()
            WorksSection()
            AboutSection()
            ContactSection()
        }
    }
}
