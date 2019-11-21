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
    public List<Departamento> findByNome(String nome) {
        List<Departamento> deps = MorphiaUtil.getDatastore().createQuery(Departamento.class)
                .field("nome")
                .contains(nome).asList();
        return deps;

    }
    @Override
    public Departamento findByNumero(int numero) {
        Query<Departamento> dep = MorphiaUtil.getDatastore().createQuery(Departamento.class)
                .filter("numero", numero);
        return dep.get();

    }


}
