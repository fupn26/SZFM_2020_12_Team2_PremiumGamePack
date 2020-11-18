package daogame.data;

import central.util.jpa.GenericJpaDao;
import com.google.inject.persist.Transactional;

import java.util.List;

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

    /**
     * Returns the list of {@code n} last results.
     *
     * @param n the maximum number of results to be returned
     * @return the list of {@code n} last results
     */
    @Transactional
    public List<GameResult> findLast(int n) {
        return entityManager.createQuery("SELECT r FROM GameResult r ORDER BY r.created DESC ", daogame.data.GameResult.class)
                .setMaxResults(n)
                .getResultList();
    }

}
