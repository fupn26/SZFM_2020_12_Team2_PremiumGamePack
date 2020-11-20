package swegame.data;

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
}
