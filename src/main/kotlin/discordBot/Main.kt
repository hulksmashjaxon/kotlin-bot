package org.example.discordBot
import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
import org.example.discordBot.listeners.SlashCommandListener
import java.util.EnumSet
import org.example.discordBot.resources.*

fun main() {
    val env = dotenv {  }
    val jda = JDABuilder.createLight(env.get("TOKEN")?: error("Missing token"), EnumSet.of(
        GatewayIntent.GUILD_MESSAGES,
        GatewayIntent.MESSAGE_CONTENT,
        GatewayIntent.GUILD_MEMBERS)).addEventListeners(SlashCommandListener()).build()

    jda.updateCommands().addCommands(*commands.toTypedArray()).queue()
}