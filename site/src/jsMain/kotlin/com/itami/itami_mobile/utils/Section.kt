package com.itami.itami_mobile.utils

enum class Section(
    val text: String,
    val id: String,
    val href: String = "#$id",
) {
    Start(
        id = "start",
        text = "Start"
    ),
    About(
        id = "about",
        text = "About me"
    ),
    Works(
        id = "works",
        text = "Works"
    ),
    Contact(
        id = "contact",
        text = "Contact me"
    )
}