package com.abheekd.apcsbot.listeners;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        event.retrieveUser().queue((user) -> {
            switch (event.getEmoji().asUnicode().getName()) {
                case "1️⃣":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById("1059510790790582272")).queue();
                    break;
                case "6️⃣":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById("1059510782511030343")).queue();
                    break;
            }
        });
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        event.retrieveUser().queue((user) -> {
            switch (event.getEmoji().asUnicode().getName()) {
                case "1️⃣":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById("1059510790790582272")).queue();
                    break;
                case "6️⃣":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById("1059510782511030343")).queue();
                    break;
            }
        });
    }
}
