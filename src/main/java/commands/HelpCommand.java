package commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelpCommand extends ListenerAdapter {
    public void help(Message message) {
        message.reply("Help!").queue();
    }
}
