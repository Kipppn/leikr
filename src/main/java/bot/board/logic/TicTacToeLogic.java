package bot.board.logic;

import commands.games.TicTacToeCommand;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.Random;

public class TicTacToeLogic {
    private final Random random = new Random();
    private final TicTacToeCommand tictactoe = new TicTacToeCommand();
    private ButtonInteractionEvent buttonInteractionEvent;
    private String playerTurnText;
    private boolean player1Turn;
    private boolean gameIsFinished = false;

    // TODO: implement way to switch between AI and two users; Probably pass in whether a second user was called or NULL.
    // Constructor(s)
    public TicTacToeLogic() {
        startGame();
    }

    /**
     * Keep track of player turn
     * @return boolean of whether it's player 1's turn
     */
    public boolean isPlayer1Turn() {
        return player1Turn;
    }

    /**
     * Tell the user whose turn it is
     * @return String text of whose turn it currently is
     */
    public String getPlayerTurnText() {
        return playerTurnText;
    }

    /**
     * Change player turns
     */
    public void changeTurn() {
        this.player1Turn = !player1Turn;
        if (player1Turn) {
            this.playerTurnText = "X Turn";
        }
        else {
            this.playerTurnText = "O Turn";
        }
    }

    /**
     * Start the Tic Tac Toe game
     * @throws NullPointerException
     */
    private void startGame() {
        firstTurn();
    }

    /**
     * End current game session if winner is determined
     */
    private void checkWinner() {

    }

    /**
     * Determine which player is going first
     */
    private void firstTurn() {
        if(random.nextInt(2) == 0) {
            this.player1Turn = true;
            this.playerTurnText = "X Turn";
        }
        else {
            this.player1Turn = false;
            this.playerTurnText = "O Turn";
        }
    }
}
