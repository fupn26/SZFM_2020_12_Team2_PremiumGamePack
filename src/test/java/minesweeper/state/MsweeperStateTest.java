package minesweeper.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MsweeperStateTest {
    @Test
    void testThreeArgConstructor_InvalidArg() {
        assertThrows(IllegalArgumentException.class, () -> new MsweeperState(0,1,0));
        assertThrows(IllegalArgumentException.class, () -> new MsweeperState(3,4,13));
        assertThrows(IllegalArgumentException.class, () -> new MsweeperState(-1,-13, 10));
    }

    @Test
    void testThreeArgConstructor_ValidArg() {
    }

    @Test
    void testOneArgConstructor_InvalidArg() {
    }

    @Test
    void testOneArgConstructor_ValidArg() {
    }
}
