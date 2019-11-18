package dao.morphia;

import dao.GenericDAO;
import morphia.MorphiaUtil;

import java.util.List;

public class GenericMorphiaDAO<T> implements GenericDAO<T> {

    private Class<T> persistenceClass;

    public GenericMorphiaDAO(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }

    @Override
    public void save(Object entity) {
        MorphiaUtil.getDatastore().save(entity);
    }

    @Override
    public void saveAll(Iterable<T> entities) {
        MorphiaUtil.getDatastore().save(entities);
    }

    @Override
    public void delete(Object entity) { MorphiaUtil.getDatastore().delete(entity); }

    @Override
    public T find(Object id) {
        return MorphiaUtil.getDatastore().get(persistenceClass, id);
    }

    @Override
    public List findAll() {
        return MorphiaUtil.getDatastore().createQuery(persistenceClass).asList();
    }

}
