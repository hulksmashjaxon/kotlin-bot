package org.example.discordBot.listeners

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.components.MessageTopLevelComponent
import net.dv8tion.jda.api.components.container.Container
import net.dv8tion.jda.api.components.separator.Separator
import net.dv8tion.jda.api.components.textdisplay.TextDisplay
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.Command
import org.example.discordBot.commands.Moderation
import org.json.JSONArray
import java.awt.Color
import java.time.Instant

class SlashCommandListener : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        val eventName = event.name
        when (eventName) {
            "hello-world" -> {
                event.reply("Hello world!").setEphemeral(true).queue()
            }

            "warn" -> {
                val user = event.getOption("user")!!.asUser
                Moderation().warn(user)
                val embed = EmbedBuilder().setTitle("Success").setDescription("Successfully warned ${user.asMention}!")
                    .setColor(Color.GREEN).setFooter("Made in Kotlin | jxson.tech").setTimestamp(
                    Instant.now()
                ).build()
                event.replyEmbeds(embed).setEphemeral(true).queue()
            }

        }
    }
}