package daogame.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

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
}