package puckg.state;

public enum Cell {

    EMPTY,
    RED,
    BLUE,
    BLACK;

    public static Cell of(int value) {
        if (value < 0 || value >= values().length) {
            throw new IllegalArgumentException();
        }
        return values()[value];
    }

    public int getValue() {
        return ordinal();
    }

    public String toString() {
        return Integer.toString(ordinal());
    }
}
