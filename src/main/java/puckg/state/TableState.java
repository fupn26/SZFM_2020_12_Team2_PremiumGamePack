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
}
