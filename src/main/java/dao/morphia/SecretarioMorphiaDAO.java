package dao.morphia;

import dao.SecretarioDAO;
import model.Secretario;

public class SecretarioMorphiaDAO extends FuncionarioMorphiaDAO<Secretario> implements SecretarioDAO {

    public SecretarioMorphiaDAO() {
        super(Secretario.class);
    }

}
