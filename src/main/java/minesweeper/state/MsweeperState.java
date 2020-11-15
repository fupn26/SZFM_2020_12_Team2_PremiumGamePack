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
}
