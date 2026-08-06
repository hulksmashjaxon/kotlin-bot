package org.example.discordBot.commands

import net.dv8tion.jda.api.components.container.Container
import net.dv8tion.jda.api.components.separator.Separator
import net.dv8tion.jda.api.components.textdisplay.TextDisplay
import net.dv8tion.jda.api.entities.User

class Moderation {
    fun warn(user: User) {
        val component = Container.of(TextDisplay.of("## Warning"), Separator.createDivider(Separator.Spacing.SMALL),
            TextDisplay.of("Hello, world!"))

        user.openPrivateChannel().flatMap { channel ->
            channel.sendMessageComponents(component).useComponentsV2()
        }.queue()
    }
}