package dao.morphia;

import dao.PesquisasDAO;
import model.Pesquisador;
import model.Pesquisas;
import model.Projeto;
import morphia.MorphiaUtil;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class PesquisasMorphiaDAO extends GenericMorphiaDAO<Pesquisas> implements PesquisasDAO {

    public PesquisasMorphiaDAO() {
        super(Pesquisas.class);
    }

    @Override
    public List<Pesquisas> findByHoras(int horas) {
        List<Pesquisas> pesqs= MorphiaUtil.getDatastore().createQuery(Pesquisas.class)
                .field("horas")
                .equal(horas).asList();
        return pesqs;
    }
    @Override
    public List<Pesquisas> findByProjeto(Projeto p) {
        List<Pesquisas> pesqs= MorphiaUtil.getDatastore().createQuery(Pesquisas.class)
                .field("projeto")
                .equal(p).asList();
        return pesqs;
    }
    @Override
    public List<Pesquisas> findByPesquisador(Pesquisador p) {
        List<Pesquisas> pesqs= MorphiaUtil.getDatastore().createQuery(Pesquisas.class)
                .field("pesquisador")
                .equal(p).asList();
        return pesqs;
    }


}
