package ru.terra.server.db.controllers;

import org.apache.log4j.Logger;
import ru.terra.server.config.Config;
import ru.terra.server.constants.ConfigConstants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * User: Vadim Korostelev
 * Date: 11.09.13
 * Time: 10:33
 */
public abstract class AbstractJpaController<Entity> {

    protected EntityManagerFactory emf = null;
    protected Class entityClass;
    protected Config config = Config.getConfig();
    private Logger logger = Logger.getLogger(AbstractJpaController.class);

    public AbstractJpaController(Class entityClass) {
        this.emf = Persistence.createEntityManagerFactory(config.getValue(ConfigConstants.PESISTANCE_UNIT, ConfigConstants.PESISTANCE_UNIT_DEFAULT));
        this.entityClass = entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Entity get(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return (Entity) em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public List<Entity> list(boolean all, int page, int perpage) throws Exception {
        logger.info("Loading list for " + entityClass.getName() + " with all=" + all + " page=" + page + " perpage=" + perpage);
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(perpage);
                q.setFirstResult(page * perpage);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public abstract void create(Entity entity) throws Exception;

    public abstract void delete(Integer id) throws Exception;

    public abstract void update(Entity entity) throws Exception;

    public int count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root rt = cq.from(entityClass);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Class getEntityClass() {
        return entityClass;
    }
}
