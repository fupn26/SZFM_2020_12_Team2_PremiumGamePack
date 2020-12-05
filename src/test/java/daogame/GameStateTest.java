package daogame.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Test
    void testGameStateIntArrayInt() {
        assertThrows(NullPointerException.class,() -> new GameState(null, 1));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameState(new int[][]{{0, 1, 1, 0}, {0, 2, 2, 0}, {0, 1, 1, 0}, {0, 2, 2, 0}}, 0);
                });
        assertEquals("Invalid startID", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameState(new int[][]{{0, 1, 1, 0}, {0, 2, 2, 0}, {0, 1, 1, 0}}, 1);
                });
        assertEquals("Invalid board", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameState(new int[][]{{0, 1, 1, 0}, {0, 2, 2, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}}, 2);
                });
        assertEquals("Invalid board", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameState(new int[][]{{0, 2, 2, 0}, {0, 2, 2, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}}, 2);
                });
        assertEquals("Invalid board", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
                () -> {
                    new GameState(new int[][]{{1, 1, 1}, {2, 2, 0}, {1, 2, 0}, {2, 0, 0}}, 2);
                });
        assertEquals("Invalid board", e.getMessage());

        assertDoesNotThrow(
                () -> {
                    new GameState(new int[][]{{1, 1, 1, 0}, {2, 2, 0, 0}, {1, 2, 0, 0}, {2, 0, 0, 0}}, 2);
                });
    }

    @Test
    void testOp() {
        GameState state = new GameState();
        Position from = new Position(0, 0);
        Position to = new Position(0, 1);
        int a = state.getActualState()[from.getRow()][from.getColumn()];
        int b = state.getActualState()[to.getRow()][to.getColumn()];
        state.op(from, to);

        assertEquals(b, state.getActualState()[from.getRow()][from.getColumn()]);
        assertEquals(a, state.getActualState()[to.getRow()][to.getColumn()]);
    }

    @Test
    void testIsApplicable() {
        GameState state = new GameState(new int[][]{{2, 0, 0, 1}, {0, 2, 1, 0}, {0, 1, 2, 0}, {1, 0, 0, 2}},2);

        assertFalse(state.isApplicable(new Position(0, 3), new Position(0, 2)));
        assertFalse(state.isApplicable(new Position(0, 0), new Position(0, 3)));
        assertFalse(state.isApplicable(new Position(0, 0), new Position(1, 3)));
        assertTrue(state.isApplicable(new Position(0, 0), new Position(0, 1)));
        assertTrue(state.isApplicable(new Position(0, 0), new Position(1, 0)));
        assertTrue(state.isApplicable(new Position(1, 1), new Position(1, 0)));
        assertTrue(state.isApplicable(new Position(1, 1), new Position(0, 2)));
        assertTrue(state.isApplicable(new Position(1,1), new Position(2, 0)));
        assertTrue(state.isApplicable(new Position(1, 1), new Position(0, 1)));

        state = new GameState(new int[][]{{2, 0, 0, 1}, {0, 2, 1, 0}, {0, 1, 0, 2}, {1, 0, 0, 2}}, 2);
        assertFalse(state.isApplicable(new Position(0, 0), new Position(2, 2)));
    }
}