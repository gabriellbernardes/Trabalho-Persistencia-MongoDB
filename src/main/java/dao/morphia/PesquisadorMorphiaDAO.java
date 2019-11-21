package dao.morphia;

import dao.PesquisadorDAO;
import model.Pesquisador;
import morphia.MorphiaUtil;

import java.util.List;

public class PesquisadorMorphiaDAO extends FuncionarioMorphiaDAO<Pesquisador> implements PesquisadorDAO {

    public PesquisadorMorphiaDAO() {
        super(Pesquisador.class);
    }

    @Override
    public List<Pesquisador> findByAtuacao(String atuacao) {
            List<Pesquisador> projs = MorphiaUtil.getDatastore().createQuery(Pesquisador.class)
                    .field("atuacao")
                    .contains(atuacao).asList();
            return projs;


    }
}
