package listener;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import router.ButtonRouter;
import router.CommandRouter;

import javax.annotation.Nonnull;

public class BotListener implements EventListener {
    private CommandRouter commandRouter;
    private ButtonRouter buttonRouter;

    @Override
    public void onEvent(@Nonnull GenericEvent genericEvent) {
        if (genericEvent instanceof ReadyEvent) {
            botOnline();
        }

        if (genericEvent instanceof ShutdownEvent) {
            botOffline();
        }

        // Commands
        if (genericEvent instanceof MessageReceivedEvent) {
            // Check if CommandRouter exists already…
            // If NULL, create a new one and set prefix
            if (commandRouter == null) {
                this.commandRouter = new CommandRouter();
            }

            // Pass in message to existing CommandRouter
            this.commandRouter.handleCommand((MessageReceivedEvent) genericEvent);
        }

        // Discord Button Clicks
        if (genericEvent instanceof ButtonInteractionEvent) {
            if (buttonRouter == null) {
                this.buttonRouter = new ButtonRouter();
            }
            this.buttonRouter.handleButtonClick((ButtonInteractionEvent) genericEvent);
        }
    }

    private void botOnline() {
        System.out.println("***** BOT IS READY *****");
    }

    private void botOffline() {
        System.out.println("***** BOT IS OFFLINE *****");
    }
}
