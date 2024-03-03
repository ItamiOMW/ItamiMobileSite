package com.itami.itami_mobile.utils

enum class Social(
    val link: String,
    val iconResLight: String,
    val iconResDark: String,
) {
    Email(
        link = Res.Strings.EMAIL_LINK,
        iconResLight = Res.Images.MAIL_LIGHT,
        iconResDark = Res.Images.MAIL_DARK
    ),
    Telegram(
        link = Res.Strings.TELEGRAM_LINK,
        iconResLight = Res.Images.TELEGRAM_LIGHT,
        iconResDark = Res.Images.TELEGRAM_DARK
    ),
    GitHub(
        link = Res.Strings.GITHUB_LINK,
        iconResLight = Res.Images.GITHUB_LIGHT,
        iconResDark = Res.Images.GITHUB_DARK
    ),
}