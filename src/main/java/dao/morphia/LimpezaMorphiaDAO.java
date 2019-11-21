package dao.morphia;

import dao.LimpezaDAO;
import model.Limpeza;
import morphia.MorphiaUtil;

import java.util.List;

public class LimpezaMorphiaDAO extends FuncionarioMorphiaDAO<Limpeza> implements LimpezaDAO {

    public LimpezaMorphiaDAO() {
        super(Limpeza.class);
    }

    @Override
    public List<Limpeza> findByCargo(String cargo){
        List<Limpeza> limps = MorphiaUtil.getDatastore().createQuery(Limpeza.class)
                .field("cargo")
                .contains(cargo).asList();
        return limps;
    }

    @Override
    public List<Limpeza> JornadaLimite(int horas) {
        List<Limpeza> limps = MorphiaUtil.getDatastore().createQuery(Limpeza.class)
                .field("horas")
                .equal(horas).asList();
        return limps;
    }

    @Override
    public List<Limpeza> SupervisorList(Limpeza l) {
        List<Limpeza> limps = MorphiaUtil.getDatastore().createQuery(Limpeza.class)
                .field("supervisor")
                .equal(l).asList();
        return limps;
    }

}
