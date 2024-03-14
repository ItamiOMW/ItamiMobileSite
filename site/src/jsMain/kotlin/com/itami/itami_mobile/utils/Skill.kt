package com.itami.itami_mobile.utils

enum class Skill(
    val skillName: String,
    val level: String,
    val iconResLight: String,
    val iconResDark: String,
) {
    AndroidStudio(
        skillName = "Android Studio",
        level = "Skilled",
        iconResLight = Res.Images.ANDROID_STUDIO,
        iconResDark = Res.Images.ANDROID_STUDIO,
    ),
    IntellijIdea(
        skillName = "IntelliJ IDEA",
        level = "Skilled",
        iconResLight = Res.Images.INTELLIJ_IDEA,
        iconResDark = Res.Images.INTELLIJ_IDEA,
    ),
    Kotlin(
        skillName = "Kotlin",
        level = "Skilled",
        iconResLight = Res.Images.KOTLIN,
        iconResDark = Res.Images.KOTLIN
    ),
    JetpackCompose(
        skillName = "Compose",
        level = "Skilled",
        iconResLight = Res.Images.JETPACK_COMPOSE,
        iconResDark = Res.Images.JETPACK_COMPOSE
    ),
    GitHub(
        skillName = "GitHub",
        level = "Skilled",
        iconResLight = Res.Images.GITHUB_LIGHT,
        iconResDark = Res.Images.GITHUB_DARK
    ),
    Java(
        skillName = "Java",
        level = "Novice",
        iconResLight = Res.Images.JAVA,
        iconResDark = Res.Images.JAVA
    ),
    Ktor(
        skillName = "Ktor",
        level = "Novice",
        iconResLight = Res.Images.KTOR,
        iconResDark = Res.Images.KTOR,
    ),
    Figma(
        skillName = "Figma",
        level = "Novice",
        iconResLight = Res.Images.FIGMA,
        iconResDark = Res.Images.FIGMA
    ),
    Postgresql(
        skillName = "PostgreSQL",
        level = "Novice",
        iconResLight = Res.Images.POSTGRESQL,
        iconResDark = Res.Images.POSTGRESQL
    ),
    Firebase(
        skillName = "Firebase",
        level = "Novice",
        iconResLight = Res.Images.FIREBASE,
        iconResDark = Res.Images.FIREBASE
    ),
}