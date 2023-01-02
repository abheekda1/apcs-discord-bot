package com.abheekd.apcsbot.listeners;

import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        event.retrieveMember().queue();
        if (event.getMessageId().equals("1059507669037228073")) { // class period role message
            switch (event.getEmoji().asUnicode().getName()) {
                case "1️⃣":
                    event.getGuild().addRoleToMember(event.getMember(),
                            event.getGuild().getRoleById("1059510790790582272")).queue();
                case "6️⃣":
                    event.getGuild().addRoleToMember(event.getMember(),
                            event.getGuild().getRoleById("1059510782511030343"));
            }
        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        event.retrieveMember().queue();
        if (event.getMessageId().equals("1059507669037228073")) { // class period role message
            event.retrieveUser();
            switch (event.getEmoji().asUnicode().getName()) {
                case "1️⃣":
                    event.getGuild().removeRoleFromMember(event.getMember(),
                            event.getGuild().getRoleById("1059510790790582272")).queue();
                case "6️⃣":
                    event.getGuild().removeRoleFromMember(event.getMember(),
                            event.getGuild().getRoleById("1059510782511030343")).queue();
            }
        }
    }
}
