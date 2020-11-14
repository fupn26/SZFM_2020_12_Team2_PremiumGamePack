package puckg.state;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Class representing the state of the game.
 */
@Data
public class TableState implements Cloneable{

    /**
     * The array representing the initial configuration of the table.
     */
    public static final int[][] INITIAL = {
            {1, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 3, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 1}
    };

    /**
     * The array storing the current configuration of the table.
     */
    @Setter(AccessLevel.NONE)
    private Cell[][] table;

    /**
     * A variable to store the previous player.
     */
    @Setter(AccessLevel.NONE)
    private int previousPlayer = 2;

    /**
     * Creates a {@code TableState} object representing the (original)
     * initial state of the puzzle.
     */
    public TableState() {
        this(INITIAL);
    }

    /**
     * Creates a {@code TableState} object that is initialized it with a specific array.
     * @param a and array of size 6&#xd7;6 representing the initial configuration of the table
     * @throws IllegalArgumentException if the array does not represent a valid configuration of the table
     */
    public TableState(int[][] a) {
        if(!isValidTable(a)) {
            throw new IllegalArgumentException();
        }
        initTable(a);
    }

    /**
     * Checks whether the specified table is valid.
     * @param a the table to be checked
     * @return {@code true} if the specified table is valid, {@code false} otherwise
     */
    public boolean isValidTable(int[][] a) {
        if(a == null || a.length != 6) {
            return false;
        }
        boolean foundBlack = false;
        for(int[] row : a) {
            if(row == null || row.length != 6) {
                return false;
            }
            for(int space : row) {
                if(space < 0 || space >= Cell.values().length) {
                    return false;
                }
                if(space == Cell.BLACK.getValue()) {
                    if(foundBlack) {
                        return false;
                    }
                    foundBlack = true;
                }
            }
        }
        return foundBlack;
    }

    private void initTable(int[][] a) {
        this.table = new Cell[6][6];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                this.table[i][j] = Cell.of(a[i][j]);
            }
        }
    }

    /**
     * Checks whether the specified cell is an empty cell.
     *
     * @param row the row of the cell to be checked
     * @param col the column of the cell to be checked
     * @return {@code true} if the specified cell is empty, {@code false} otherwise
     */
    public boolean isEmptyCell (int row, int col) {
        return table[row][col] == Cell.EMPTY;
    }


    /**
     * Checks whether the specified cell is black cell.
     *
     * @param row the row of the cell to be checked
     * @param col the column of the cell to be checked
     * @return {@code true} if the specified cell is black, {@code false} otherwise
     */
    public boolean isBlackCell (int row, int col) {
        return table[row][col] == Cell.BLACK;
    }


    /**
     * Checks whether is it possible to move the puck from the specified position.
     *
     * @param row the row of the puck to be moved
     * @param col the column of the puck to be moved
     * @return {@code true} if there is at least one possible position, where the puck
     * can be moved to, {@code false} otherwise
     */
    public boolean isMoveAvailable(int row, int col) {
        if(row-2 >= 0) {
            if(table[row-2][col] == Cell.EMPTY) {
                return true;
            }
            if(col-2 >= 0) {
                if(table[row-2][col-2] == Cell.EMPTY) {
                    return true;
                }
            }
            if(col+2 < 6) {
                if(table[row-2][col+2] == Cell.EMPTY) {
                    return true;
                }
            }
        }
        if(row+2 < 6) {
            if(table[row+2][col] == Cell.EMPTY) {
                return true;
            }
            if(col-2 >= 0) {
                if(table[row+2][col-2] == Cell.EMPTY) {
                    return true;
                }
            }
            if(col+2 < 6) {
                if(table[row+2][col+2] == Cell.EMPTY) {
                    return true;
                }
            }
        }
        if(col-2 >= 0) {
            if(table[row][col-2] == Cell.EMPTY) {
                return true;
            }
        }
        if(col+2 < 6) {
            if(table[row][col+2] == Cell.EMPTY) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the specified puck is able to be moved to the specified position with
     * the respect to the specified player.
     *
     * @param player the player who is willing to move the puck
     * @param rowfrom the row of the puck to be moved
     * @param colFrom the column of the puck to be moved
     * @param rowTo the row of the desired position
     * @param colTo the column of the desired position
     * @return {@code true} if the specified puck is able to be moved to the specified
     * position by the specified player, {@code false} otherwise
     */
    public boolean isMovableTo(int player, int rowfrom, int colFrom, int rowTo, int colTo) {
        if(player == previousPlayer) {
            return false;
        }
        if(Math.abs(rowfrom-rowTo) > 2 || Math.abs(colFrom-colTo) > 2) {
            return false;
        }
        if(!isEmptyCell(rowTo,colTo)) {
            return false;
        }
        if(Math.abs(rowfrom-rowTo) == 2 && Math.abs(colFrom-colTo) == 0) {
            return true;
        }
        if(Math.abs(rowfrom-rowTo) == 0 && Math.abs(colFrom-colTo) == 2) {
            return true;
        }
        if(Math.abs(rowfrom-rowTo) == 2 && Math.abs(colFrom-colTo) == 2) {
            return true;
        }
        return false;
    }

    public boolean isPuckOfPlayer (int player, int row, int col) {
        return table[row][col] == Cell.of(player);
    }

    public boolean isNewPuckAvailable (int player, int row, int col) {
        if(player == previousPlayer) {
            return false;
        }
        if(isBlackCell(row,col)) {
            return false;
        }
        if(!isEmptyCell(row,col)) {
            return false;
        }
        for(int i = row-1; i <= row+1; ++i) {
            if(i < 0 || i >= table.length) {
                continue;
            }
            for(int j = col-1; j <= col+1; ++j) {
                if(j < 0 || j >= table.length) {
                    continue;
                }
                if(table[i][j] == Cell.of(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFinished(int player) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(isNewPuckAvailable(player, i, j)) {
                    return false;
                }
                if(isPuckOfPlayer(player, i, j) && isMoveAvailable(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void afterStep (int player, int row, int col) {
        for(int i = row-1; i<= row+1; i++) {
            if(i < 0 || i >= table.length) {
                continue;
            }
            for(int j = col-1; j<= col+1; j++) {
                if(j < 0 || j >= table.length) {
                    continue;
                }
                if(table[i][j] == Cell.of(player).opposite()) {
                    table[i][j] = Cell.of(player);
                }
            }
        }
    }

    public void movePuck (int player, int rowFrom, int colFrom, int rowTo, int colTo) {
        if(!isMovableTo(player,rowFrom,colFrom,rowTo,colTo)) {
            throw new IllegalArgumentException();
        }
        table[rowFrom][colFrom] = Cell.EMPTY;
        table[rowTo][colTo] = Cell.of(player);
        afterStep(player, rowTo, colTo);
        previousPlayer = player;
    }

    public void newPuck (int player, int row, int col) {
        if(!isNewPuckAvailable(player, row, col)) {
            throw new IllegalArgumentException();
        }
        table[row][col] = Cell.of(player);
        afterStep(player, row, col);
        previousPlayer = player;
    }

    public int pointsOfPlayer (int player) {
        int result = 0;
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                if(table[i][j] == Cell.of(player))
                {
                    result++;
                }
            }
        }
        return result;
    }

    public int numberOfEmptyCells () {
        int result = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(isEmptyCell(i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    public TableState clone() {
        TableState copy = null;
        try {
            copy = (TableState) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        copy.table = new Cell[table.length][];
        for (int i = 0; i < table.length; ++i) {
            copy.table[i] = table[i].clone();
        }
        return copy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : table) {
            for (Cell cell : row) {
                sb.append(cell).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
