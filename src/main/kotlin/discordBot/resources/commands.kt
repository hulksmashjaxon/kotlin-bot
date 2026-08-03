package org.example.discordBot.resources

import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData

val commands: List<SlashCommandData> = listOf(
    Commands.slash("hello-world", "Returns hello world")
)