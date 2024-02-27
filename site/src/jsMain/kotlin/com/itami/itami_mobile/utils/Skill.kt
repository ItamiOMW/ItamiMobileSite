package com.itami.itami_mobile.utils

enum class Skill(
    val skillName: String,
    val experience: String,
    val iconResLight: String,
    val iconResDark: String,
) {
    AndroidStudio(
        skillName = "Android Studio",
        experience = "2+ Years",
        iconResLight = Res.Images.ANDROID_STUDIO,
        iconResDark = Res.Images.ANDROID_STUDIO,
    ),
    IntellijIdea(
        skillName = "IntelliJ IDEA",
        experience = "2+ Years",
        iconResLight = Res.Images.INTELLIJ_IDEA,
        iconResDark = Res.Images.INTELLIJ_IDEA,
    ),
    Kotlin(
        skillName = "Kotlin",
        experience = "2 Years",
        iconResLight = Res.Images.KOTLIN,
        iconResDark = Res.Images.KOTLIN
    ),
    Java(
        skillName = "Java",
        experience = "5 Months",
        iconResLight = Res.Images.JAVA,
        iconResDark = Res.Images.JAVA
    ),
    JetpackCompose(
        skillName = "Jetpack Compose",
        experience = "1+ Years",
        iconResLight = Res.Images.JETPACK_COMPOSE,
        iconResDark = Res.Images.JETPACK_COMPOSE
    ),
    Ktor(
        skillName = "Ktor",
        experience = "7 Months",
        iconResLight = Res.Images.KTOR,
        iconResDark = Res.Images.KTOR,
    ),
    Figma(
        skillName = "Figma",
        experience = "7 Months",
        iconResLight = Res.Images.FIGMA,
        iconResDark = Res.Images.FIGMA
    ),
    Postgresql(
        skillName = "PostgreSQL",
        experience = "6 Months",
        iconResLight = Res.Images.POSTGRESQL,
        iconResDark = Res.Images.POSTGRESQL
    ),
    Firebase(
        skillName = "Firebase",
        experience = "2 Months",
        iconResLight = Res.Images.FIREBASE,
        iconResDark = Res.Images.FIREBASE
    ),
    GitHub(
        skillName = "GitHub",
        experience = "1+ Years",
        iconResLight = Res.Images.GITHUB_LIGHT,
        iconResDark = Res.Images.GITHUB_DARK
    )
}