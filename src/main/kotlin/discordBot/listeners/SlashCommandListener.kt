package org.example.discordBot.listeners

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SlashCommandListener: ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        val eventName = event.name
        when(eventName) {
           "hello-world" -> {
               event.reply("Hello world!").setEphemeral(true).queue()
           }
        }
    }
}