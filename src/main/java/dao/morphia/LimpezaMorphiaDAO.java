package dao.morphia;

import dao.LimpezaDAO;
import model.Limpeza;

public class LimpezaMorphiaDAO extends FuncionarioMorphiaDAO<Limpeza> implements LimpezaDAO {

    public LimpezaMorphiaDAO() {
        super(Limpeza.class);
    }

}
