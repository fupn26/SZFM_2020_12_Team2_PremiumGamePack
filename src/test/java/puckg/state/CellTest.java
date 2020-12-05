package java.puckg.state;

import org.junit.jupiter.api.Test;
import puckg.state.Cell;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testOf() {
        assertEquals(Cell.EMPTY, Cell.of(0));
        assertEquals(Cell.RED, Cell.of(1));
        assertEquals(Cell.BLUE, Cell.of(2));
        assertEquals(Cell.BLACK, Cell.of(3));
        assertThrows(IllegalArgumentException.class, () -> Cell.of(4));
        assertThrows(IllegalArgumentException.class, () -> Cell.of(-1));
    }
}