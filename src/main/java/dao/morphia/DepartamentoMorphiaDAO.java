package dao.morphia;

import dao.DepartamentoDAO;
import model.Departamento;
import model.Projeto;
import morphia.MorphiaUtil;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.CriteriaContainerImpl;
import org.mongodb.morphia.query.Query;

import java.util.List;

public class DepartamentoMorphiaDAO extends GenericMorphiaDAO<Departamento> implements DepartamentoDAO {

    public DepartamentoMorphiaDAO() {
        super(Departamento.class);
    }
    @Override
    public List<Departamento> findAll() {
        List<Departamento> deps = MorphiaUtil.getDatastore().createQuery(Departamento.class).asList();
        return deps;
    }
    @Override
    public Departamento findDep(int numero, String nome) {
        Query<Departamento> dep = MorphiaUtil.getDatastore().createQuery(Departamento.class)
                .field("nome").contains(nome)
                .filter("numero" , numero);
        return dep.get();

    }


}
