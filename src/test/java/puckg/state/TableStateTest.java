package puckg.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TableStateTest {

    @Test
    void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new TableState(new int[][] {
                {2, 2, 0, 0, 0, 2, 0},
                {0, 2, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 2, 2, 0},
                {2, 0, 0, 0, 2, 2, 0}}));
    }
}
