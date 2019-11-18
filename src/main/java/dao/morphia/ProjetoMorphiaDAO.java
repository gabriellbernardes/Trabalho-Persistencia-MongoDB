package dao.morphia;

import dao.ProjetoDAO;
import model.Projeto;

public class ProjetoMorphiaDAO extends GenericMorphiaDAO<Projeto> implements ProjetoDAO {

    public ProjetoMorphiaDAO() {
        super(Projeto.class);
    }

}
