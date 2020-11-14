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
}
