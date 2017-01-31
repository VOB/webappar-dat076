package orm.db;

import orm.model.TodoNote;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *  Base class for any DAO
 * @author hajo
 * @param <T> Data type
 * @param <K> Primary type
 */
public class AbstractDAO<T,K> implements Serializable, IDAO<T, K> {

    private EntityManagerFactory emf = null;
    private final Class<T> clazz;
    
    public AbstractDAO(EntityManagerFactory emf, Class<T> clazz) {
        this.emf = emf;
        this.clazz = clazz;
    }
   
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void add(T t) {
        // This is application managed persistence so have to handle
        // transactions manually
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    @Override
    public void update(T t) {
        // TODO
    }

    @Override
    public void delete(K id) {
        // TODO
    }

    @Override
    public List<T> get() {
        return get(true, -1, -1);
    }

    @Override
    public List<T> get(int maxResults, int firstResult) {
        return get(false, maxResults, firstResult);
    }

    // Below we use the standar Criteria query API.
    // Don't use elsewhere (ugly) Use Querydsl!
    private List<T> get(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TodoNote.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public T getById(K id) {
        EntityManager em = getEntityManager();
        return em.find(clazz, id);
    }

    @Override
    public int size() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<TodoNote> rt = cq.from(TodoNote.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();

    }

   
}
