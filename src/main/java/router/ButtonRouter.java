package router;

import bot.board.logic.TicTacToeLogic;
import commands.games.TicTacToeCommand;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.concurrent.RejectedExecutionException;

public class ButtonRouter {
    private final TicTacToeLogic logic = new TicTacToeLogic();
    private final TicTacToeCommand ticTacToeCommand = new TicTacToeCommand();

    /**
     * Handle Game Logic
     * @param event
     * @throws RejectedExecutionException
     * @throws IndexOutOfBoundsException
     * @throws IllegalArgumentException
     */
    public void handleButtonClick(ButtonInteractionEvent event) throws RejectedExecutionException, IndexOutOfBoundsException, IllegalArgumentException {
        var clickedButtonName = event.getComponentId();

        // Check if position is already claimed
        if (!event.getButton().getEmoji().equals(Emoji.fromUnicode("U+2796"))) {
            event.editMessage("That spot is already claimed! Please pick a different spot.").queue();
        }

        for (int i = 0; i < ticTacToeCommand.getButtonArrayList().size(); i++) {
            // Traverse ArrayList
            var button = ticTacToeCommand.getButtonArrayList().get(i);
            var messageButton = button.getId();

            // Compare button ID in ArrayList and clicked button
            if (messageButton == clickedButtonName) {
                if (logic.isPlayer1Turn()) {
                    event.editButton(Button.secondary(button.getId(), "X")).queue();
                } else {
                    event.editButton(Button.secondary(button.getId(), "O")).queue();
                }
                break;
            }
        }

        // After a VALID move is made, change player turns
        logic.changeTurn();
    }
}
