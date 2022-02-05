package listener;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import router.CommandRouter;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class BotListener implements EventListener {
    private CommandRouter router;
//    private HashMap<String, TextChannel> trackingChannels = new HashMap<>();

    @Override
    public void onEvent(@Nonnull GenericEvent genericEvent) {
        if (genericEvent instanceof ReadyEvent) {
            System.out.println("***** BOT IS READY *****");
        }

        if (genericEvent instanceof ShutdownEvent) {
            System.out.println("***** BOT IS OFFLINE *****");
        }

//        if (genericEvent instanceof GuildJoinEvent) {
//            Guild guild = ((GuildJoinEvent) genericEvent).getGuild();
//            trackingChannels.put(guild.getId(), guild.getTextChannels().get(0));
//        }

        if (genericEvent instanceof MessageReceivedEvent) {
            // Check if CommandRouter exists already…
            // If NULL, create a new one and set prefix
            if (router == null) {
                this.router = new CommandRouter();
            }

            // Pass in message to existing CommandRouter
            this.router.handleCommand((MessageReceivedEvent) genericEvent);
        }
    }
}
