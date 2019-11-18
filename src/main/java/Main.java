import dao.DepartamentoDAO;
import dao.FuncionarioDAO;
import dao.PesquisadorDAO;
import dao.PesquisasDAO;
import dao.ProjetoDAO;
import dao.morphia.DepartamentoMorphiaDAO;
import dao.morphia.PesquisadorMorphiaDAO;
import dao.morphia.PesquisasMorphiaDAO;
import dao.morphia.ProjetoMorphiaDAO;
import model.Departamento;
import model.Dependente;
import model.Endereco;
import model.Pesquisador;
import model.Pesquisas;
import model.Projeto;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        DepartamentoDAO depDAO = new DepartamentoMorphiaDAO();
//        List<Departamento> deps = new ArrayList<Departamento>();
//        deps.add(new Departamento("secretaria", 2));
//        deps.add(new Departamento("laboratorio", 3));
//        depDAO.saveAll(deps);
//
        ProjetoDAO projDAO = new ProjetoMorphiaDAO();
//        Projeto proj = new Projeto("horas complementares", 1, new Date(), new Date(),
//                depDAO.find(new ObjectId("5dd16d20146ef75b750cc635")));
//        projDAO.save(proj);
//        Departamento dep = depDAO.find(new ObjectId("5dd16c9b9d0e9f23e3eeaa9c"));
//        dep.setNome("diretoria");
//        depDAO.save(dep);
        Projeto proj = projDAO.find(new ObjectId("5dd16dc6cc52d60b0d07e2a8"));
        PesquisadorDAO pesqDAO = new PesquisadorMorphiaDAO();
//        Endereco end = new Endereco("rua a", 22, "casa c", "jardim", "ararara");
//        Pesquisador pesq = new Pesquisador("joao", "masc", new Date(), 10236.45, dep, end, "contador");
//        pesq.addDependente(new Dependente("maria", "fem", new Date(), "esposa"));
//        pesqDAO.save(pesq);
        Pesquisador pesq = pesqDAO.find(new ObjectId("5dd16fe73061e648f5fccf39"));

        PesquisasDAO pqDAO = new PesquisasMorphiaDAO();
        Pesquisas pq = new Pesquisas(proj, pesq, 10);
        pqDAO.save(pq);
    }

}