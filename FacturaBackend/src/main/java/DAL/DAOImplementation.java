package DAL;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;

public abstract class DAOImplementation<I, E> extends SessionHandler implements DAO<I, E> {
    protected Class<E> entityClass;

    public DAOImplementation() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperClass.getActualTypeArguments()[1];
    }

    public void create(E entity) {
        getCurrentSession().persist(entity);
        databaseInteractionWithTransaction();
    }

    public E read(I index) {
        return getCurrentSession().get(entityClass, (Serializable) index);
    }

    public Set<E> readAll(){
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        criteriaQuery.from(entityClass);
        return new HashSet<E>(getCurrentSession().createQuery(criteriaQuery).getResultList());
    }

    public void update(E entity) {
        getCurrentSession().update(entity);
        databaseInteractionWithTransaction();
    }

    public void delete(E entity) {
        getCurrentSession().delete(entity);
        databaseInteractionWithTransaction();
    }
}
