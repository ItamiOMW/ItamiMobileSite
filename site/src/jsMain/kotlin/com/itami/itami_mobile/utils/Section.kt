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
    Works(
        id = "works",
        text = "Works"
    ),
    About(
        id = "about",
        text = "About me"
    ),
    Contact(
        id = "contact",
        text = "Contact me"
    )
}