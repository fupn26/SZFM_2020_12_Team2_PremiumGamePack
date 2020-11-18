package daogame.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GameResult {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * The name of player 1.
     */
    @Column(nullable = false)
    private String player1;

    /**
     * The name of player 2.
     */
    @Column(nullable = false)
    private String player2;

    /**
     * The ID of the actual player.
     */
    private int turnID;

    /**
     * The name of the winner.
     */
    private String winner;

    /**
     * Indicates whether the game is ended.
     */
    @Column(nullable = false)
    private boolean ended;

    /**
     * The duration of the game.
     */
    @Column(nullable = false)
    private Duration duration;

    /**
     * Gives the row-wise representation of the board matrix.
     */
    @ElementCollection
    @Column(name="board", nullable=false)
    private List<Integer> board;

    /**
     * The timestamp when the result was saved.
     */
    @Column(nullable = false)
    private ZonedDateTime created;
}
