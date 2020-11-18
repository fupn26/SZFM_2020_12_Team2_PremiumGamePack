package daogame.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Class representing the result of a game played by two players.
 */
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
     * The duration of the game.
     */
    @Column(nullable = false)
    private Duration duration;

    /**
     * The timestamp when the result was saved.
     */
    @Column(nullable = false)
    private ZonedDateTime created;

    @PrePersist
    protected void onPersist() {
        created = ZonedDateTime.now();
    }
}
