package triplepuck.data;

import central.util.jpa.GenericJpaDao;
import com.google.inject.persist.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * DAO class for the {@link GResult} entity.
 */
public class GResultDao extends GenericJpaDao<GResult> {
    /**
     * Constructor for the class.
     */
    public GResultDao() {
        super(GResult.class);
    }

    /**
     * Returns the list of the last {@code n} games.
     *
     * @param n the maximum number of results to be returned
     * @return the list of the last {@code n} games.
     */
    @Transactional
    public List<GResult> findLast(int n) {
        return entityManager.createQuery("SELECT r FROM GResult r ORDER BY  r.created DESC", GResult.class)
                .setMaxResults(n)
                .getResultList();
    }

    @Transactional
    public void deleteData() {
        Query query = entityManager.createQuery("DELETE FROM GResult");
        query.executeUpdate();
    }

}
