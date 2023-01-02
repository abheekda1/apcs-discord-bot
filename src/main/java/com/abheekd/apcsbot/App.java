package com.abheekd.apcsbot;

import com.abheekd.apcsbot.listeners.ReactionListener;
import com.abheekd.apcsbot.listeners.ReadyListener;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class App 
{
    public static void main(String[] args)
            throws InterruptedException
    {
        // Note: It is important to register your ReadyListener before building
        JDA jda = JDABuilder.createDefault(System.getenv("TOKEN"))
            .addEventListeners(new ReadyListener(), new ReactionListener())
            .build();

        // optionally block until JDA is ready
        jda.awaitReady();
    }
}
