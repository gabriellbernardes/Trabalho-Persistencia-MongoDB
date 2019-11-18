package dao;

import java.util.List;

public interface GenericDAO<T> {

    void save(T entity);

    void saveAll(Iterable<T> entities);

    void delete(T entity);

    T find(Object id);

    List<T> findAll();

}
