package org.example.discordBot.resources

import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData

val commands: List<SlashCommandData> = listOf(
    Commands.slash("hello-world", "Returns hello world"),
    Commands.slash("warn", "Warns a user").addOption(OptionType.USER, "user", "Select a user to warn", true),
    Commands.slash("play", "Plays a song").addOption(OptionType.STRING, "song", "The name of the song", true, true),
)