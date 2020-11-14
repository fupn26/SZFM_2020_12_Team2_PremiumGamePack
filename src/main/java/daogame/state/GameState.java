package daogame.state;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

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
    public boolean isApplicable(Position from, Position to) {
        return true;
    }

    /**
     * Returns whether the move from {@code from} position to {@code to} position is permitted in the
     * perspective of available directions.
     * @param from the actual position of the piece
     * @param to the new position of the piece
     * @return {@code true} if the {@code from} to {@code to} movement is a permitted direction,
     * {@code false} otherwise
     */
    private boolean isValidDirection(Position from, Position to) {
        double x = abs(to.getColumn() - from.getColumn());
        double y = abs(to.getRow() - from.getRow());

        if(x == 0 || y == 0) {
            return true;
        }

        return y/x == 1.0;
    }

    /**
     * Returns whether there is any piece between the {@code from} position and the {@code to} position.
     * @param from the piece actual position
     * @param to the piece new position
     * @return {@code true} if there is not any pieces between the given positions,
     * {@code false} otherwise
     */
    private boolean isWayClear(daogame.state.Position from, daogame.state.Position to) {
        return true;
    }

    /**
     * Returns whether there are any pieces between the {@code start} and the {@code end} columns at the given {@code row}.
     * @param row the row number of {@code start} and {@code end}
     * @param start the column number where the checking starts
     * @param end the column number where the checking ends
     * @return {@code true} if there are not any pieces at the given range,
     * {@code false} otherwise
     */
    private boolean isWayClearHor(int row, int start, int end){
        return IntStream.range(start, end).noneMatch(i -> actualState[row][i] != 0);
    }


}
