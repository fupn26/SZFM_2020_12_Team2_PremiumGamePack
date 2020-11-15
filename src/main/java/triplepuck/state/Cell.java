package swegame.state;
/**
 * Class representing a cell and its possible content.
 */

public enum Cell {
    /**
     * Represents the empty cell.
     */
    EMPTY,
    /**
     * Represents a red cell.
     */
    RED,
    /**
     * Represents a blue cell.
     */
    BLUE;

    /**
     * Returns the instance represented by the value specified.
     *
     * @param value the value representing an instance
     * @return the instance represented by the value specified
     * @throws IllegalArgumentException if the value specified does not
     * represent an instance
     */
    public static Cell of(int value) {
        if (value < 0 || value >= values().length) {
            throw new IllegalArgumentException();
        }
        return values()[value];
    }

}
