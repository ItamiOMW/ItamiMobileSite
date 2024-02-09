package com.itami.itami_mobile.theme.fonts

import com.itami.itami_mobile.utils.Res
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.modifiers.FontScope
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.cssRem

data class SiteFont(
    val fontFamily: String,
    val fontSize: CSSSizeValue<CSSUnit.rem>,
    val fontWeight: FontWeight = FontWeight.Normal,
    val fontStyle: FontStyle = FontStyle.Normal
)

data class SiteFonts(
    val display: SiteFont,
    val subDisplay: SiteFont,
    val title: SiteFont,
    val bodyLarge: SiteFont,
    val bodyMedium: SiteFont,
    val bodySmall: SiteFont,
    val labelLarge: SiteFont,
    val labelMedium: SiteFont,
    val labelSmall: SiteFont
)

fun Breakpoint.toSiteFonts() = Fonts[this]

fun FontScope.siteFont(siteFont: SiteFont) {
    this.style(siteFont.fontStyle)
    this.size(siteFont.fontSize)
    this.weight(siteFont.fontWeight)
    this.family(siteFont.fontFamily)
}

object Fonts {

    operator fun get(breakpoint: Breakpoint) = when (breakpoint) {
        Breakpoint.ZERO -> {
            smallFonts
        }

        Breakpoint.SM -> {
            smallFonts
        }

        Breakpoint.MD -> {
            mediumFonts
        }

        Breakpoint.LG -> {
            largeFonts
        }

        Breakpoint.XL -> {
            superLargeFonts
        }
    }

    private val superLargeFonts = SiteFonts(
        display = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_MEDIUM,
            fontWeight = FontWeight.Medium,
            fontSize = 2.25.cssRem,
        ),
        subDisplay = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_REGULAR,
            fontWeight = FontWeight.Normal,
            fontSize = 1.5.cssRem,
        ),
        title = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_MEDIUM,
            fontWeight = FontWeight.Medium,
            fontSize = 1.5.cssRem,
        ),
        bodyLarge = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_REGULAR,
            fontWeight = FontWeight.Normal,
            fontSize = 1.25.cssRem,
        ),
        bodyMedium = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_REGULAR,
            fontWeight = FontWeight.Normal,
            fontSize = 1.1.cssRem,
        ),
        bodySmall = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_REGULAR,
            fontWeight = FontWeight.Normal,
            fontSize = 0.875.cssRem,
        ),
        labelLarge = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_MEDIUM,
            fontWeight = FontWeight.Medium,
            fontSize = 1.cssRem,
        ),
        labelMedium = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_MEDIUM,
            fontWeight = FontWeight.Medium,
            fontSize = 0.875.cssRem,
        ),
        labelSmall = SiteFont(
            fontFamily = Res.FontFamilies.POPPINS_MEDIUM,
            fontWeight = FontWeight.Medium,
            fontSize = 0.75.cssRem,
        ),
    )

    private val largeFonts = SiteFonts(
        display = superLargeFonts.display.copy(fontSize = 2.1.cssRem),
        subDisplay = superLargeFonts.subDisplay.copy(fontSize = 1.35.cssRem),
        title = superLargeFonts.title.copy(fontSize = 1.35.cssRem),
        bodyLarge = superLargeFonts.bodyLarge.copy(fontSize = 1.15.cssRem),
        bodyMedium = superLargeFonts.bodyMedium.copy(fontSize = 1.cssRem),
        bodySmall = superLargeFonts.bodySmall.copy(fontSize = 0.775.cssRem),
        labelLarge = superLargeFonts.labelLarge.copy(fontSize = 0.9.cssRem),
        labelMedium = superLargeFonts.labelMedium.copy(fontSize = 0.825.cssRem),
        labelSmall = superLargeFonts.labelSmall.copy(fontSize = 0.7.cssRem),
    )

    private val mediumFonts = SiteFonts(
        display = superLargeFonts.display.copy(fontSize = 1.95.cssRem),
        subDisplay = superLargeFonts.subDisplay.copy(fontSize = 1.2.cssRem),
        title = superLargeFonts.title.copy(fontSize = 1.35.cssRem),
        bodyLarge = superLargeFonts.bodyLarge.copy(fontSize = 1.cssRem),
        bodyMedium = superLargeFonts.bodyMedium.copy(fontSize = 0.9.cssRem),
        bodySmall = superLargeFonts.bodySmall.copy(fontSize = 0.8.cssRem),
        labelLarge = superLargeFonts.labelLarge.copy(fontSize = 0.9.cssRem),
        labelMedium = superLargeFonts.labelMedium.copy(fontSize = 0.8.cssRem),
        labelSmall = superLargeFonts.labelSmall.copy(fontSize = 0.7.cssRem),
    )

    private val smallFonts = SiteFonts(
        display = superLargeFonts.display.copy(fontSize = 1.8.cssRem),
        subDisplay = superLargeFonts.subDisplay.copy(fontSize = 1.05.cssRem),
        title = superLargeFonts.title.copy(fontSize = 1.35.cssRem),
        bodyLarge = superLargeFonts.bodyLarge.copy(fontSize = 1.cssRem),
        bodyMedium = superLargeFonts.bodyMedium.copy(fontSize = 0.9.cssRem),
        bodySmall = superLargeFonts.bodySmall.copy(fontSize = 0.8.cssRem),
        labelLarge = superLargeFonts.labelLarge.copy(fontSize = 1.cssRem),
        labelMedium = superLargeFonts.labelMedium.copy(fontSize = 0.9.cssRem),
        labelSmall = superLargeFonts.labelSmall.copy(fontSize = 0.8.cssRem),
    )
}