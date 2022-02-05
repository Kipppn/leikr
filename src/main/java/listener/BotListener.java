package listener;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import router.CommandRouter;

import javax.annotation.Nonnull;

public class BotListener implements EventListener {
    private CommandRouter router;

    @Override
    public void onEvent(@Nonnull GenericEvent genericEvent) {
        if (genericEvent instanceof ReadyEvent) {
            System.out.println("***** BOT IS READY *****");
        }

        if (genericEvent instanceof ShutdownEvent) {
            System.out.println("***** BOT IS OFFLINE *****");
        }

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
