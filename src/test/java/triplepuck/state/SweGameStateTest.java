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

    @Test
    void testOneArgConstructor_ValidArg() {
        int[][] a = new int[][] {
                {2, 1, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 2, 1, 2}
        };
        SweGameState state = new SweGameState(a);
        assertArrayEquals(new Cell[][] {
                {Cell.BLUE,Cell.RED,Cell.BLUE,Cell.RED},
                {Cell.EMPTY,Cell.EMPTY,Cell.EMPTY,Cell.EMPTY},
                {Cell.EMPTY,Cell.EMPTY,Cell.EMPTY,Cell.EMPTY},
                {Cell.EMPTY,Cell.EMPTY,Cell.EMPTY,Cell.EMPTY},
                {Cell.RED,Cell.BLUE,Cell.RED,Cell.BLUE}
        }, state.getBoard());
    }


    @Test
    void testIsGoal(){
        assertFalse(new SweGameState().isGoal());
        assertTrue(new SweGameState(new int[][] {
                {2, 2, 2, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 2, 1, 1}
        }).isGoal());
        assertTrue(new SweGameState(new int[][] {
                {2, 0, 0, 1},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 2, 1, 1}
        }).isGoal());
        assertTrue(new SweGameState(new int[][] {
                {2, 0, 2, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 2, 2, 0}
        }).isGoal());
    }


}