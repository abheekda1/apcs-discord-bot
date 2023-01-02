package com.abheekd.apcsbot;

import com.abheekd.apcsbot.listeners.ReactionListener;
import com.abheekd.apcsbot.listeners.ReadyListener;

import com.abheekd.apcsbot.listeners.commands.GetHelpCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.Arrays;

public class App {
    private static boolean hasArg(String arg, String[] args) {
        for (String a : args) {
            if (a.equals(arg)) return true;
        }
        return false;
    }

    public static void main(String[] args)
            throws InterruptedException
    {
        // Note: It is important to register your ReadyListener before building
        JDA jda = JDABuilder.createDefault(System.getenv("TOKEN"))
            .addEventListeners(new ReadyListener(), new ReactionListener(), new GetHelpCommand())
            .build();

        // optionally block until JDA is ready
        jda.awaitReady();

        Guild apcsGuild = jda.getGuildById("1059475915916193873");
        if (hasArg("--publish-commands", args)) {
            System.out.printf("Publishing commands to %s!", apcsGuild);
            if (apcsGuild != null) {
                apcsGuild.updateCommands().addCommands(
                        Commands.slash("get-help", "Pings the people who have dedicated their lives to AP CS service.")
                                .addOption(OptionType.STRING, "reason", "Supply the root cause of all your troubles and insecurities.", false, false)
                ).queue();
            }
        }
    }
}
