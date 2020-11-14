package puckg.state;

public class TableState {

    public static final int[][] INITIAL = {
            {1, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 3, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 1}
    };

    private Cell[][] table;

    private int previousPlayer = 2;

    public TableState() {
        this(INITIAL);
    }

    public TableState(int[][] a) {
        if(!isValidTable(a)) {
            throw new IllegalArgumentException();
        }
        initTable(a);
    }

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

    public boolean isEmptyCell (int row, int col) {
        return table[row][col] == Cell.EMPTY;
    }

    public boolean isBlackCell (int row, int col) {
        return table[row][col] == Cell.BLACK;
    }

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
}
