import dao.DepartamentoDAO;
import dao.FuncionarioDAO;
import dao.PesquisadorDAO;
import dao.PesquisasDAO;
import dao.ProjetoDAO;
import dao.morphia.*;
import model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PesquisasDAO pqDAO = new PesquisasMorphiaDAO();
        PesquisadorDAO pesqDAO = new PesquisadorMorphiaDAO();
        DepartamentoDAO depDAO = new DepartamentoMorphiaDAO();
        ProjetoDAO projDAO = new ProjetoMorphiaDAO();
//        deps.add(new Departamento("secretaria", 2));
//        deps.add(new Departamento("laboratorio", 3));
//        depDAO.saveAll(deps);

//        Departamento deps = depDAO.findByNumero(2);
//        List <Projeto> projs = projDAO.findByNome("horas complementares");
        List<Funcionario> funcs =  pesqDAO.SalarioMaiorQ(1500.00, Pesquisador.class);
        System.out.println(funcs.get(0).getAniversario());
//        List<Departamento> departamentos= projDAO.findByNumeroDep(projDAO.findByNome("horas complementares").get(0).getDepartamento().getNumero());
//        System.out.println(departamentos);
//                MorphiaUtil.getDatastore().createQuery(Pesquisador.class)
//                .field("nome")
//                .contains("joao").asList();
     // System.out.println(funcs);
//            Projeto proj = new Projeto("horas complementares", 1, new Date(), new Date(),
//                    depDAO.find(d.getId()));
//            projDAO.save(proj);


//            Departamento dep = depDAO.find(new ObjectId("5dd16c9b9d0e9f23e3eeaa9c"));
//            dep.setNome("diretoria");
//            depDAO.save(dep);

//            Endereco end = new Endereco("rua a", 22, "casa c", "jardim", "ararara");
//            Pesquisador pesq = new Pesquisador("joao", "masc", new Date(), 10236.45, d, end, "contador");
//            pesq.addDependente(new Dependente("maria", "fem", new Date(), "esposa"));
//            pesqDAO.save(pesq);
//            Pesquisas pq = new Pesquisas(projs.get(0), pesq, 10);
//            pqDAO.save(pq);



    }

}