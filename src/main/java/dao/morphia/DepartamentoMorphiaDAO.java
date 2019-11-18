package dao.morphia;

import dao.DepartamentoDAO;
import model.Departamento;

public class DepartamentoMorphiaDAO extends GenericMorphiaDAO<Departamento> implements DepartamentoDAO {

    public DepartamentoMorphiaDAO() {
        super(Departamento.class);
    }

}
