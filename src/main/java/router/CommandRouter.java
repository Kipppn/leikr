package router;

import commands.HelpCommand;
import commands.games.TicTacToeCommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandRouter extends ListenerAdapter {
    // Prefix For Bot
    private String prefix = "-";
    private TicTacToeCommand ttt;
    private HelpCommand helpCommand;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Handles incoming commands from user
     * @param event
     */
    public void handleCommand(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String text = message.getContentRaw();
        String[] messageParts = text.split(" ");

        // Checking For The Correct Prefix
        if(!text.substring(0, 1).equals(prefix)) {
            return;
        }

        switch(messageParts[0].toLowerCase()) {
            // Ping is so simple, there's no need to move it to its own module
            case "-ping":
                message.reply("Pong!").queue();
                break;
            case "-help":
                if (helpCommand == null) {
                    this.helpCommand = new HelpCommand();
                }
                helpCommand.help(message);
                break;
            case "-ttt":
                if (ttt == null) {
                    this.ttt = new TicTacToeCommand();
                }
                ttt.tttCommand(message);
                break;
        }
    }
}
