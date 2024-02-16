package com.itami.itami_mobile.utils

enum class Skill(
    val skillName: String,
    val experience: String,
    val iconRes: String,
) {
    AndroidStudio(
        skillName = "Android Studio",
        experience = "2+ Years",
        iconRes = Res.Images.ANDROID_STUDIO
    ),
    Kotlin(
        skillName = "Kotlin",
        experience = "2 Years",
        iconRes = Res.Images.KOTLIN
    ),
    Ktor(
        skillName = "Ktor",
        experience = "8 Months",
        iconRes = Res.Images.KTOR
    ),
    Figma(
        skillName = "Figma",
        experience = "8 Months",
        iconRes = Res.Images.FIGMA
    ),
}