package com.abheekd.apcsbot.listeners.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

import java.awt.*;
import java.util.Date;
import java.util.HashMap;

public class GetHelpCommand extends ListenerAdapter {
    static HashMap<String, Date> cooldown = new HashMap<>();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("get-help")) {
            Date now = new Date();
            if (cooldown.containsKey(event.getUser().getId())) {
                Date complete = cooldown.get(event.getUser().getId());
                if (complete.after(now)) {
                    MessageEmbed embed = new EmbedBuilder().setColor(new Color(255, 50, 50)).setDescription(String.format("⌛ You can use this <t:%d:R> dumbass spammer", complete.getTime() / 1000)).build();
                    event.replyEmbeds(embed).queue();
                    return;
                } else {
                    cooldown.remove(event.getUser().getId());
                    cooldown.put(event.getUser().getId(), new Date(now.getTime() + 30 * 1000));
                }
            } else {
                cooldown.put(event.getUser().getId(), new Date(now.getTime() + 30 * 1000));
            }

            MessageCreateBuilder dataBuilder = new MessageCreateBuilder().addContent("<@&1059507014306373792>");

            if (event.getOption("reason") != null) {
                MessageEmbed embed = new EmbedBuilder().setAuthor(event.getUser().getAsTag(), null, event.getUser().getEffectiveAvatarUrl()).setDescription(event.getOption("reason").getAsString()).build();
                dataBuilder.addEmbeds(embed);
            }

            event.reply(dataBuilder.build()).queue();
        }
    }
}
