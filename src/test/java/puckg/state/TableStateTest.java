package puckg.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @Test
    void testIsValidTable() {
        assertTrue(new TableState().isValidTable(TableState.INITIAL));
        assertFalse(new TableState().isValidTable(new int[][] {
                {2, 2, 0, 0, 0, 2, 0},
                {0, 2, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 2, 2, 0},
                {2, 0, 0, 0, 2, 2, 0}}));
        assertFalse(new TableState().isValidTable(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 2, 2},
                {0, 0, 0, 0, 0, 0}}));
        assertFalse(new TableState().isValidTable(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 2, 2}}));
        assertFalse(new TableState().isValidTable(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 2, -1}}));
        assertFalse(new TableState().isValidTable(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0},
                {0, 0, 0, 3, 2, 2},
                {2, 0, 0, 0, 2, 2}}));
    }

    @Test
    void testIsFinished() {
        assertFalse(new TableState().isFinished(1));
        assertTrue(new TableState(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 2, 2}}).isFinished(1));
        assertFalse(new TableState(new int[][] {
                {1, 0, 0, 0, 0, 2},
                {2, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 2, 2}}).isFinished(1));

    }

    @Test
    void testIsMoveAvailable() {
        assertTrue(new TableState().isMoveAvailable(0, 0));
        assertTrue(new TableState(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 2},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 2, 1}}).isMoveAvailable(5, 5));
        assertTrue(new TableState(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 2, 2, 1}}).isMoveAvailable(5, 5));
        assertTrue(new TableState(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0},
                {0, 0, 0, 3, 0, 2},
                {0, 0, 2, 0, 1, 2},
                {2, 0, 0, 2, 2, 2}}).isMoveAvailable(4, 4));
        assertFalse(new TableState(new int[][] {
                {2, 2, 0, 0, 0, 2},
                {0, 2, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 2},
                {0, 0, 0, 0, 2, 2},
                {2, 0, 0, 2, 2, 1}}).isMoveAvailable(5, 5));
        assertTrue(new TableState(new int[][] {
                {2, 2, 2, 0, 0, 2},
                {0, 2, 2, 0, 2, 0},
                {2, 0, 1, 0, 2, 0},
                {0, 0, 0, 3, 0, 2},
                {2, 0, 2, 0, 2, 2},
                {2, 0, 0, 2, 2, 2}}).isMoveAvailable(2, 2));
        assertTrue(new TableState(new int[][] {
                {2, 2, 2, 0, 2, 2},
                {0, 2, 2, 0, 2, 0},
                {2, 0, 1, 0, 2, 0},
                {0, 0, 0, 3, 0, 2},
                {0, 0, 2, 0, 2, 2},
                {2, 0, 0, 2, 2, 2}}).isMoveAvailable(2, 2));
        assertTrue(new TableState(new int[][] {
                {2, 2, 2, 0, 2, 2},
                {0, 2, 2, 0, 2, 0},
                {2, 0, 1, 0, 2, 0},
                {0, 0, 0, 3, 0, 2},
                {2, 0, 2, 0, 0, 2},
                {2, 0, 0, 2, 2, 2}}).isMoveAvailable(2, 2));
        assertTrue(new TableState(new int[][] {
                {2, 2, 2, 0, 2, 2},
                {0, 2, 2, 0, 2, 0},
                {2, 0, 1, 0, 0, 0},
                {0, 0, 0, 3, 0, 2},
                {2, 0, 2, 0, 2, 2},
                {2, 0, 0, 2, 2, 2}}).isMoveAvailable(2, 2));
    }
}
