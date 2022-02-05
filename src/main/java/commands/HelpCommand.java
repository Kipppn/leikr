package commands;

import net.dv8tion.jda.api.entities.Message;

public class HelpCommand {
    public void help(Message message) {
        message.reply("Help!").queue();
    }
}
