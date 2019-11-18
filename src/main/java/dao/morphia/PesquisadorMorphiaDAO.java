package dao.morphia;

import dao.PesquisadorDAO;
import model.Pesquisador;

public class PesquisadorMorphiaDAO extends FuncionarioMorphiaDAO<Pesquisador> implements PesquisadorDAO {

    public PesquisadorMorphiaDAO() {
        super(Pesquisador.class);
    }

}
