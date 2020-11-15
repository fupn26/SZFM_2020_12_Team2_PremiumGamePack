package triplepuck.state;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Class representing the state of the game.
 */
@Data
@Slf4j
public class TpGameState implements Cloneable {

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


}
