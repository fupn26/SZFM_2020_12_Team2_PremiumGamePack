package swegame.state;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Class representing the state of the game.
 */
@Data
@Slf4j
public class SweGameState implements Cloneable {

    /**
     * The array representing the initial configuration of the board.
     */
    public static final int[][] INITIAL = {
            {2, 1, 2, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 2, 1, 2}
    };

    /**
     * The array storing the current configuration of the board.
     */
    @Setter(AccessLevel.NONE)
    private Cell[][] board;

    private int player = 1;

    /**
     * Creates a {@code SweGameState} object representing the (original)
     * initial state of the game.
     */
    public SweGameState() {
        this(INITIAL);
    }

    /**
     * Creates a {@code SweGameState} object that is initialized it with
     * the specified array.
     *
     * @param a an array of size 5;4 representing the initial configuration
     *          of the tray
     * @throws IllegalArgumentException if the array does not represent a valid
     *                                  configuration of the tray
     */
    public SweGameState(int[][] a) {
        if (!isValidBoard(a)) {
            throw new IllegalArgumentException();
        }
        initBoard(a);
    }

    private boolean isValidBoard(int[][] a) {
        if (a == null || a.length != 5) {
            return false;
        }
        int red = 0, blue = 0;
        for (int[] row : a) {
            if (row == null || row.length != 4) {
                return false;
            }
            for (int space : row) {
                if (space < 0 || space >= Cell.values().length) {
                    return false;
                }
                if (space == Cell.RED.getValue()) {
                    red++;
                }
                if (space == Cell.BLUE.getValue()) {
                    blue++;
                }
            }
        }
        return red == 4 && blue == 4;

    }


    private void initBoard(int[][] a) {
        this.board = new Cell[5][4];
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 4; ++j) {
                this.board[i][j] = Cell.of(a[i][j]);
            }
        }
    }




}
