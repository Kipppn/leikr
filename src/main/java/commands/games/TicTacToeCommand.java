package commands.games;

import bot.board.logic.TicTacToeLogic;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

public class TicTacToeCommand extends ListenerAdapter {
    private ArrayList<Button> buttonArrayList = new ArrayList<>();

    /**
     * Returns Tic Tac Toe Game
     * @param message
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws RejectedExecutionException
     */
    public void tttCommand(Message message) throws IllegalStateException, IllegalArgumentException, RejectedExecutionException {
        TicTacToeLogic logic = new TicTacToeLogic();
        String messageTitle = logic.getPlayerTurnText();

        // Prep
        setUpButtons();

        // REPLY with Game Board
        try {
            // TODO: Create method that is called inside setActionRows()
            //  Move ActionRow.of() into GameBoard Class
            //  Scalable to be able to pass in different board sizes
            //  Might look into using Enum classes to classify this.
            message.reply(messageTitle).setActionRows(
                    ActionRow.of(buttonArrayList.get(0), buttonArrayList.get(1), buttonArrayList.get(2)),
                    ActionRow.of(buttonArrayList.get(3), buttonArrayList.get(4), buttonArrayList.get(5)),
                    ActionRow.of(buttonArrayList.get(6), buttonArrayList.get(7), buttonArrayList.get(8))
            ).queue();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds buttons to Array
     */
    private void setUpButtons() {
        int count = 1;
        for (int i = 0; i < 9; i++) {
            buttonArrayList.add(Button.secondary("box" + count, Emoji.fromUnicode("U+2796")));
            count++;
        }
    }

    public ArrayList<Button> getButtonArrayList() {
        return this.buttonArrayList;
    }
}
