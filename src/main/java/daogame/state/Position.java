package daogame.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Class representing a position in matrix.
 */
@Data
@AllArgsConstructor
@Builder
public class Position {
    /**
     * Column number of this {@link Position}.
     */
    private int column;
    /**
     * Row number of this {@link Position}.
     */
    private int row;
}
