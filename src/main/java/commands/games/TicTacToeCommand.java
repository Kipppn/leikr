package commands.games;

import net.dv8tion.jda.api.entities.Message;

public class TicTacToeCommand {
    public void tttCommand(Message message) {
        message.reply("Tic Tac Toe").queue();
//        message.replyEmbeds().queue();
    }
}
