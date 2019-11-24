package menu;

import dao.DepartamentoDAO;
import dao.ProjetoDAO;
import dao.morphia.DepartamentoMorphiaDAO;
import dao.morphia.ProjetoMorphiaDAO;
import model.Departamento;
import model.Projeto;
import morphia.MorphiaUtil;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;


import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.util.Date;
import java.util.List;

public class CrudProj {
    private Projeto proj;
    private final DepartamentoDAO departamentoDAO = new DepartamentoMorphiaDAO();
    private final ProjetoDAO projDao = new ProjetoMorphiaDAO();

    public CrudProj() {
    }

    public void AddDProj() {
        JLabel title = new JLabel("Cadastro Projeto");
        JTextField nome = new JTextField();
        JTextField numero = new JTextField();
        JTextField dataI = new JTextField();
        JTextField dataF = new JTextField();
        JTextField numDep = new JTextField();
        JTextField nomDep = new JTextField();

        final JComponent[] inputs = new JComponent[] {
                title,
                new JLabel("Nome"),
                nome,
                new JLabel("Numero"),
                numero,
                new JLabel("Data de Inicio"),
                dataI,
                new JLabel("Data de Fim"),
                dataF ,
                new JLabel("Nome Departamento"),
                nomDep,
                new JLabel("Numero Departamento"),
                numDep
        };
        JOptionPane.showMessageDialog(null, inputs, "Cadastro", JOptionPane.PLAIN_MESSAGE);

        Date cI = new Date(dataI.getText());
        Date cF = new Date(dataF.getText());

        Departamento dep = departamentoDAO.findDep(Integer.parseInt(numDep.getText()), nomDep.getText());

        if(dep == null) {
            JOptionPane.showMessageDialog(null, "Departamento não existe!!");
            return;
        }
        proj = MorphiaUtil.getDatastore().createQuery(Projeto.class).field("nome")
                .contains(nome.getText())
                .field("numero")
                .equal(Integer.parseInt(numero.getText()))
                .get();

        if(proj==null) {
            projDao.save( new Projeto(nome.getText(),Integer.parseInt(numero.getText()), cI,cF ,dep));
            JOptionPane.showMessageDialog(null, "Adicionado!!");
        }else{
            JOptionPane.showMessageDialog(null, "Erro!!\nProjeto já existe");

        }
    }

    public void UpdateProj(){
        String projNome = JOptionPane.showInputDialog("Digite o Nome do Projeto");
        int numeroProj = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero do Projeto"));


        Query<Projeto> query = MorphiaUtil.getDatastore().createQuery(Projeto.class)
                .field("nome").contains(projNome).field("numero").equal(numeroProj);
        proj =  query.get();
        boolean a = (proj != null);
        JOptionPane.showMessageDialog(null, a ?  proj:"Nenhum Projeto encontrado");

        if(a) {
            UpdateOperations<Projeto> updates = MorphiaUtil.getDatastore().createUpdateOperations(Projeto.class)
                    .set(JOptionPane.showInputDialog("Campo a ser atualizado"), JOptionPane.showInputDialog("Preencha"));
            MorphiaUtil.getDatastore().update(query, updates);
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar!!");
            return;
        }
    }
    public void DeleteProj(){

        String nome = JOptionPane.showInputDialog("Digite o Nome do Deparatamento");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero do Deparatamento"));
        Departamento dep =  departamentoDAO.findDep(numero, nome);;
        if (dep != null) {
            String projNome = JOptionPane.showInputDialog("Digite o Nome do Projeto");
            int numeroProj = Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero do Projeto"));

            Query<Projeto> query  = MorphiaUtil.getDatastore().createQuery(Projeto.class).field("departamento")
                    .equal(dep).field("nome").contains(projNome).field("numero").equal(numeroProj);

            MorphiaUtil.getDatastore().delete(query);
            JOptionPane.showMessageDialog(null, "Apagado com sucesso");
        } else {
            if(proj == null) JOptionPane.showMessageDialog(null, "Projeto não existe!!");
            return;
        }
    }
    public void FindByNome(String nome){
        List<Projeto> projetoList= projDao.findByNomeList(nome);
        StringBuilder listagem = new StringBuilder();
        for(Projeto d: projetoList) {
            listagem.append(d).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Vazio" : listagem);
    }
}