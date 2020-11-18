package daogame.data;

import central.util.jpa.GenericJpaDao;

/**
 * DAO class for the {@link daogame.data.GameResult} entity.
 */
public class GameResultDao extends GenericJpaDao<GameResult> {

    /**
     * Constructs a {@link GameResultDao} object by calling the parent's constructor.
     */
    public GameResultDao() {
        super(GameResult.class);
    }
}
