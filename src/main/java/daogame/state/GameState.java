package daogame.state;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Class representing the state of the game.
 */
@Data
@Slf4j
public class GameState {
    /**
     * Array representing the game's actual state.
     */
    @Setter(AccessLevel.NONE)
    private int[][] actualState = {{2, 0, 0, 1},
            {0, 2, 1, 0},
            {0, 1, 2, 0},
            {1, 0, 0, 2}};

    /**
     * Variable representing the actual player.
     */
    @Setter(AccessLevel.NONE)
    private int turnID;

    /**
     * Variable representing the winner.
     */
    @Setter(AccessLevel.NONE)
    private int winnerID;

    /**
     * Constructs a {@link GameState} object with random {@code turnID} between 1 and 2.
     */
    public GameState() {
        turnID = new Random().nextInt(2) + 1;
        log.info("TurnID = {}", turnID);
        winnerID = -1;
    }

    /**
     * Move the piece from the {@code from} position to the {@code to} position.
     * @param from the actual position of the piece
     * @param to the new position of the piece
     */
    public void op(Position from, Position to) {
        int temp = actualState[to.getRow()][to.getColumn()];
        actualState[to.getRow()][to.getColumn()] = actualState[from.getRow()][from.getColumn()];
        actualState[from.getRow()][from.getColumn()] = temp;
        changeTurn();
    }

    /**
     * Changes the {@code turnID} to the ID of the next player.
     */
    private void changeTurn() {
        turnID = (turnID == 1) ? 2 : 1;
    }

    /**
     * Returns whether the piece can be moved from the {@code from} position to the {@code to} position.
     * @param from the actual position of the piece
     * @param to the new position of the piece
     * @return {@code true} if the piece can be moved to the {@code to} position,
     * {@code false} otherwise
     */
    public boolean isApplicable(daogame.state.Position from, daogame.state.Position to) {
        return true;
    }

}
