package dao.morphia;

import dao.SecretarioDAO;
import model.Secretario;
import morphia.MorphiaUtil;

import java.util.List;

public class SecretarioMorphiaDAO extends FuncionarioMorphiaDAO<Secretario> implements SecretarioDAO {

    public SecretarioMorphiaDAO() {
        super(Secretario.class);
    }


    @Override
    public List<Secretario> findByEscolaridade(String horas) {
            List<Secretario> secs = MorphiaUtil.getDatastore().createQuery(Secretario.class)
                    .field("horas")
                    .equal(horas).asList();
            return secs;

        }

}
