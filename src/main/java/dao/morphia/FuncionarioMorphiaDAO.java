package dao.morphia;

import dao.FuncionarioDAO;

public class FuncionarioMorphiaDAO<T> extends GenericMorphiaDAO<T> implements FuncionarioDAO<T> {

    public FuncionarioMorphiaDAO(Class<T> persistenceClass) {
        super(persistenceClass);
    }

}
