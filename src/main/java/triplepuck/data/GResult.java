package triplepuck.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.time.ZonedDateTime;

/**
 * Class representing the result of a game played by a specific player.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class GResult {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * The name of the red player.
     */
    @Column(nullable = false)
    private String redplayer;

    /**
     * The name of the blue player.
     */
    @Column(nullable = false)
    private String blueplayer;

    /**
     * The player who has won the game.
     */
    private String winner;


    /**
     * The number of steps made by the player.
     */
    private int steps;

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
