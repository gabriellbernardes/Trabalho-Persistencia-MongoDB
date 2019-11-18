package dao.morphia;

import dao.PesquisasDAO;
import model.Pesquisas;

public class PesquisasMorphiaDAO extends GenericMorphiaDAO<Pesquisas> implements PesquisasDAO {

    public PesquisasMorphiaDAO() {
        super(Pesquisas.class);
    }

}
