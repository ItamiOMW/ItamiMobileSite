package com.itami.itami_mobile.theme

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.palette.*

@InitSilk
fun initSilkPalette(ctx: InitSilkContext) {
    ctx.apply {
        theme.palettes.apply {
            light.apply {
                val brandPrimary = Color.rgb(r = 109, g = 66, b = 153)
                background = Color.rgb(r = 230, g = 230, b = 230)
                color = Color.rgb(r = 0, g = 0, b = 25)
                overlay = Color.rgb(r = 218, g = 217, b = 227)
                brand.set(
                    primary = brandPrimary,
                    onPrimary = Color.rgb(r = 217, g = 217, b = 217)
                )
                text.set(
                    primary = Color.rgb(r = 0, g = 0, b = 25),
                    secondary = Color.rgb(r = 64, g = 64, b = 64)
                )
                button.set(
                    default = brandPrimary,
                    hover = brandPrimary.darkened(byPercent = 0.1f),
                    focus = brandPrimary,
                    pressed = brandPrimary.darkened(byPercent = 0.2f)
                )
            }

            dark.apply {
                val brandPrimary = Color.rgb(r = 77, g = 39, b = 118)
                background = Color.rgb(r = 22, g = 21, b = 29)
                color = Color.rgb(r = 204, g = 204, b = 204)
                overlay = Color.rgb(r = 29, g = 28, b = 38)
                brand.set(
                    primary = brandPrimary,
                    onPrimary = Color.rgb(r = 217, g = 217, b = 217)
                )
                text.set(
                    primary = Color.rgb(r = 204, g = 204, b = 204),
                    secondary = Color.rgb(r = 171, g = 171, b = 171)
                )
                button.set(
                    default = brandPrimary,
                    hover = brandPrimary.lightened(byPercent = 0.1f),
                    focus = brandPrimary,
                    pressed = brandPrimary.lightened(byPercent = 0.2f)
                )
            }
        }
    }
}

// Custom Text colors for the Silk theme
val Palette.text: Text get() = (this as MutablePalette).text
val MutablePalette.text: MutableText
    get() = MutableText(this)

interface Text {
    val primary: Color
    val secondary: Color
}

class MutableText(palette: MutablePalette) : MutablePalette.ColorGroup(palette = palette, groupName = "text"), Text {
    override var primary: Color by paletteEntry()
    override var secondary: Color by paletteEntry()

    fun set(
        primary: Color,
        secondary: Color,
    ) {
        this.primary = primary
        this.secondary = secondary
    }
}


// Custom Brand colors for the Silk theme
val Palette.brand: Brand get() = (this as MutablePalette).brand
val MutablePalette.brand: MutableBrand
    get() = MutableBrand(this)

interface Brand {
    val primary: Color
    val onPrimary: Color
}

class MutableBrand(palette: MutablePalette) : MutablePalette.ColorGroup(palette = palette, groupName = "brand"), Brand {
    override var primary: Color by paletteEntry()
    override var onPrimary: Color by paletteEntry()

    fun set(
        primary: Color,
        onPrimary: Color,
    ) {
        this.primary = primary
        this.onPrimary = onPrimary
    }
}