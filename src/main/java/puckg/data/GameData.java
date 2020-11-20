package puckg.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.Duration;
import java.time.ZonedDateTime;

public class GameData {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String winner;

    @Column(nullable = false)
    private int winnerPoints;

    @Column(nullable = false)
    private String second;

    @Column(nullable = false)
    private int secondPoints;

    @Column(nullable = false)
    private Duration duration;

    @Column(nullable = false)
    private ZonedDateTime created;

    @PrePersist
    protected void onPersist() {
        created = ZonedDateTime.now();
    }

}
