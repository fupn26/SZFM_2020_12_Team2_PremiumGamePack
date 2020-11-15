package minesweeper.state;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Class representing the state of the puzzle.
 */
@Data
@Slf4j
public class MsweeperState implements Cloneable {


    /**
     * Random object to generate random numbers.
     */
    private Random random = new Random();

    /**
     * Array representing where the mines are in the grid.
     */
    private int[][] minegrid;

    /**
     * Array representing where the flags are in the grid.
     */
    private int[][] flaggrid;

    /**
     * Array representing which squares are revealed in the grid.
     */
    private int[][] revealgrid;

    /**
     * Array representing the number of mines adjacent to each grid.
     */
    private int[][] aroundgrid;

    /**
     * The number of rows in the grid.
     */
    private int rownumber;

    /**
     * The number of columns in the grid.
     */
    private int colnumber;

    /**
     * Creates a {@code MsweeperState} object with mines randomly placed in it.
     *
     * @param rows    the number of rows in the grid
     * @param columns the number of columns in the grid
     * @param mines   the number of mines to be randomly placed in the grid
     * @throws IllegalArgumentException if there are more mines than squares, or if the number of rows or columns are not positive
     */
    public MsweeperState(int rows, int columns, int mines) {
        if (rows * columns >= mines && rows > 0 && columns > 0) {
            rownumber = rows;
            colnumber = columns;
            initGrid();
            placeMines(mines);
            calculateMinesAround();
        } else throw new IllegalArgumentException();
    }

    /**
     * Creates a {@code MsweeperState} object from a predefined grid.
     *
     * @param incomingminegrid the predefined grid to create the object from
     * @throws IllegalArgumentException if the predefined grid isn't a valid minefield
     */
    public MsweeperState(int[][] incomingminegrid) {
        if (!isValidMinefield(incomingminegrid)) throw new IllegalArgumentException();
        rownumber = incomingminegrid.length;
        colnumber = incomingminegrid[0].length;
        initGrid();
        for (int i = 0; i < rownumber; ++i) {
            for (int j = 0; j < colnumber; ++j) {
                minegrid[i][j] = incomingminegrid[i][j];
            }
        }
        calculateMinesAround();
    }

    private void initGrid() {
        minegrid = new int[rownumber][colnumber];
        flaggrid = new int[rownumber][colnumber];
        revealgrid = new int[rownumber][colnumber];
        aroundgrid = new int[rownumber][colnumber];

        for (int i = 0; i < rownumber; ++i) {
            for (int j = 0; j < colnumber; ++j) {
                minegrid[i][j] = 0;
                flaggrid[i][j] = 0;
                revealgrid[i][j] = 0;
                aroundgrid[i][j] = 0;
            }
        }
    }

    /**
     * Places a number of mines in the grid, randomly.
     *
     * @param numberofminestoplace the number of mines to place in the grid
     */
    private void placeMines(int numberofminestoplace) {
        for (int i = 0; i < numberofminestoplace; ++i) {
            int x = random.nextInt(rownumber);
            int y = random.nextInt(colnumber);
            while (minegrid[x][y] == 1) {
                x = random.nextInt(rownumber);
                y = random.nextInt(colnumber);
            }
            minegrid[x][y] = 1;
        }
    }

    /**
     * Calculates the number of mines around each square in the grid, and sets the values of {@code aroundgrid} to it.
     */
    private void calculateMinesAround() {
        for (int i = 0; i < rownumber; ++i) {
            for (int j = 0; j < colnumber; ++j) {
                if (minegrid[i][j] == 1) {
                    if (isExistingSquare(i - 1, j - 1)) aroundgrid[i - 1][j - 1]++;
                    if (isExistingSquare(i - 1, j)) aroundgrid[i - 1][j]++;
                    if (isExistingSquare(i - 1, j + 1)) aroundgrid[i - 1][j + 1]++;
                    if (isExistingSquare(i + 1, j - 1)) aroundgrid[i + 1][j - 1]++;
                    if (isExistingSquare(i + 1, j)) aroundgrid[i + 1][j]++;
                    if (isExistingSquare(i + 1, j + 1)) aroundgrid[i + 1][j + 1]++;
                    if (isExistingSquare(i, j - 1)) aroundgrid[i][j - 1]++;
                    if (isExistingSquare(i, j + 1)) aroundgrid[i][j + 1]++;
                }
            }
        }
    }

    private boolean isExistingSquare(int x, int y) {
        if (x >= 0 && y >= 0 && x < rownumber && y < colnumber) {
            return true;
        }
        return false;
    }

    private boolean isValidMinefield(int[][] minefield) {
        int firstrowlength = minefield[0].length;
        if (firstrowlength == 0) return false;
        for (int[] row : minefield) {
            if (row.length != firstrowlength) return false;
            for (int field : row) {
                if (field != 1 && field != 0) return false;
            }
        }
        return true;
    }

    /**
     * Places or removes a flag from the targeted square, depending on if there was one there to begin with.
     *
     * @param x the x coordinate of the square
     * @param y the y coordinate of the square
     * @throws IllegalArgumentException if the targeted square does not exist
     */
    public void putFlag(int x, int y) {
        if (isExistingSquare(x, y)) {
            if (revealgrid[x][y] == 0) {
                flaggrid[x][y] = (flaggrid[x][y] + 1) % 2;
                log.info("Flag placed/removed at square ({}, {})", x, y);;
            }
        } else throw new IllegalArgumentException();
    }

    /**
     * Reveals the targeted square, and recursively reveals squares around it until one is found which has a mine around it.
     *
     * @param x the x coordinate of the square
     * @param y the y coordinate of the square
     * @throws IllegalArgumentException if the targeted square does not exist
     */
    public void reveal(int x, int y) {
        if (isExistingSquare(x, y)) {
            if (revealgrid[x][y] == 0 && flaggrid[x][y] == 0) {
                log.info("Square at ({}, {}) is revealed", x, y);
                revealgrid[x][y] = 1;
                if (aroundgrid[x][y] == 0) {
                    if (isExistingSquare(x - 1, y - 1)) reveal(x - 1, y - 1);
                    if (isExistingSquare(x - 1, y)) reveal(x - 1, y);
                    if (isExistingSquare(x - 1, y + 1)) reveal(x - 1, y + 1);
                    if (isExistingSquare(x, y - 1)) reveal(x, y - 1);
                    if (isExistingSquare(x, y + 1)) reveal(x, y + 1);
                    if (isExistingSquare(x + 1, y - 1)) reveal(x + 1, y - 1);
                    if (isExistingSquare(x + 1, y)) reveal(x + 1, y);
                    if (isExistingSquare(x + 1, y + 1)) reveal(x + 1, y + 1);
                }
            }
        } else throw new IllegalArgumentException();
    }
}
