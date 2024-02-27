package com.itami.itami_mobile.utils

enum class Work(
    val workName: String,
    val description: String,
    val link: String,
    val imageRes: String,
) {
    CalorieTracker(
        workName = "Calorie Tracker",
        description = "Android & Backend & Design",
        link = "https://github.com/ItamiOWM/CalorieTracker",
        imageRes = Res.Images.CALORIE_TRACKER_THUMBNAIL
    ),
    Messenger(
        workName = "Messenger",
        description = "Android & Backend & Design",
        link = "https://github.com/ItamiOWM/Messenger",
        imageRes = Res.Images.MESSENGER_THUMBNAIL
    ),
    Notes(
        workName = "Notes",
        description = "Android & Backend & Design",
        link = "https://github.com/ItamiOWM/NotesWithRESTAPI",
        imageRes = Res.Images.NOTES_THUMBNAIL
    ),

    // Temporary solution, Todo: add more works.
    MessengerCopy(
        workName = "Messenger",
        description = "Android & Backend & Design",
        link = "https://github.com/ItamiOWM/Messenger",
        imageRes = Res.Images.MESSENGER_THUMBNAIL
    ),
    NotesCopy(
        workName = "Notes",
        description = "Android & Backend & Design",
        link = "https://github.com/ItamiOWM/NotesWithRESTAPI",
        imageRes = Res.Images.NOTES_THUMBNAIL
    ),
    TicTacToe(
        workName = "Tic Tac Toe",
        description = "Design",
        link = "https://www.figma.com/file/S0hhAOGOxQMRuhoqiJf14p/Tic-Tac-Toe?type=design&node-id=0%3A1&mode=design&t=v43yZwGCCRgZfZsw-1",
        imageRes = "images/tic_tac_toe.png"
    )
}