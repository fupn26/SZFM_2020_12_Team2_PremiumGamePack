package puckg.data;

import central.util.jpa.GenericJpaDao;
import com.google.inject.persist.Transactional;

import javax.persistence.Query;
import java.util.List;

public class GameDataDao extends GenericJpaDao<GameData> {

    public GameDataDao() {
        super(GameData.class);
    }

    @Transactional
    public List<GameData> findBestByTime(int n) {
        return entityManager.createQuery("SELECT r FROM GameData r ORDER BY r.duration ASC, r.created DESC", GameData.class)
                .setMaxResults(n)
                .getResultList();
    }

    @Transactional
    public List<GameData> findBestByPoint(int n) {
        return entityManager.createQuery("SELECT r FROM GameData r ORDER BY r.winnerPoints DESC, r.duration ASC", GameData.class)
                .setMaxResults(n)
                .getResultList();
    }

    @Transactional
    public void deleteData() {
        Query query = entityManager.createQuery("DELETE FROM GameData");
        query.executeUpdate();
    }
}
