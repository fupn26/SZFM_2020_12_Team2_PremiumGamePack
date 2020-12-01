package swegame.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SweGameStateTest {

    @Test
    void testOneArgConstructor_InvalidArg(){
        assertThrows(IllegalArgumentException.class, () -> new SweGameState(null));
        assertThrows(IllegalArgumentException.class, () -> new SweGameState(new int[][] {
                {1, 1},
                {1, 0}})
        );
        assertThrows(IllegalArgumentException.class, () -> new SweGameState(new int[][] {
                {0},
                {1, 2},
                {3, 4, 5}})
        );
        assertThrows(IllegalArgumentException.class, () -> new SweGameState(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {1, 2, 3},
                {1, 2, 3},})
        );
        assertThrows(IllegalArgumentException.class, () -> new SweGameState(new int[][] {
                {1, 1, 5, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}})
        );
        assertThrows(IllegalArgumentException.class, () -> new SweGameState(new int[][] {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}})
        );
        assertThrows(IllegalArgumentException.class, () -> new SweGameState(new int[][] {
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {2, 0, 2, 0},
                {0, 2, 0, 0},
                {0, 2, 1, 0}})
        );
    }


}