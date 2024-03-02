package com.itami.itami_mobile.utils

import androidx.compose.runtime.Composable
import com.itami.itami_mobile.theme.icons.*
import com.varabyte.kobweb.silk.components.style.toModifier

enum class Social(
    val link: String,
    val content: @Composable () -> Unit
) {
    Email(
        link = Res.Strings.EMAIL_LINK,
        content =  {
            EmailIcon(
                modifier = IconStyle.toModifier(MediumIconSize)
            )
        }
    ),
    Telegram(
        link = Res.Strings.TELEGRAM_LINK,
        content =  {
            TelegramIcon(
                modifier = IconStyle.toModifier(MediumIconSize)
            )
        }
    ),
    GitHub(
        link = Res.Strings.GITHUB_LINK,
        content =  {
            GitHubIcon(
                modifier = IconStyle.toModifier(MediumIconSize)
            )
        }
    ),
}