package DAL;

import java.util.Set;

public interface DAO<I,E> {
    void create(E entity);
    E read(I index);
    Set<E> readAll();
    void update(E entity);
    void delete(E entity);
}
