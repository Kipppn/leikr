package commands.games;

import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

public class TicTacToeCommand extends ListenerAdapter {
    private String messageTitle = "~~~~~~ Tic Tac Toe ~~~~~~";
//    private ArrayList<ActionRow> gameBoard = new ArrayList<>(3);

    /**
     * Returns Tic Tac Toe Game
     * @param message
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     */
    public void tttCommand(Message message) throws IllegalStateException, IllegalArgumentException, RejectedExecutionException {
        try {
            message.reply(messageTitle).setActionRows(
                    ActionRow.of(
                            Button.secondary("top left corner", Emoji.fromUnicode("U+2796"))
                                    .withId("row_0_button_0"),
                            Button.secondary("top middle", Emoji.fromUnicode("U+2796"))
                                    .withId("row_0_button_1"),
                            Button.secondary("top right corner", Emoji.fromUnicode("U+2796"))
                                    .withId("row_0_button_2")
                    ),
                    ActionRow.of(
                            Button.secondary("middle left", Emoji.fromUnicode("U+2796"))
                                    .withId("row_1_button_0"),
                            Button.secondary("middle", Emoji.fromUnicode("U+2796"))
                                    .withId("row_1_button_1"),
                            Button.secondary("middle right", Emoji.fromUnicode("U+2796"))
                                    .withId("row_1_button_2")
                    ),
                    ActionRow.of(
                            Button.secondary("bottom left corner", Emoji.fromUnicode("U+2796"))
                                    .withId("row_2_button_0"),
                            Button.secondary("bottom middle", Emoji.fromUnicode("U+2796"))
                                    .withId("row_2_button_1"),
                            Button.secondary("bottom right corner", Emoji.fromUnicode("U+2796"))
                                    .withId("row_2_button_2")
                    )
            ).queue();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
