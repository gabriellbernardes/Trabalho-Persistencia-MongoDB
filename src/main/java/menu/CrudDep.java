package menu;

import dao.DepartamentoDAO;
import dao.morphia.DepartamentoMorphiaDAO;
import model.Departamento;
import morphia.MorphiaUtil;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import javax.swing.JOptionPane;
import java.util.List;

public class CrudDep {
    private Departamento departamento;
    private final DepartamentoDAO departamentoDAO = new DepartamentoMorphiaDAO();

    public CrudDep() {
    }

    public void AddDep() {
        String nome = JOptionPane.showInputDialog("Digite o Nome do Departamento");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do Departamento"));
        departamento =  MorphiaUtil.getDatastore().createQuery(Departamento.class)
                .field("nome")
                .equal(nome)
                .field("numero")
                .equal(numero)
                .get();

        if(departamento == null) {
            departamento = new Departamento(nome, numero);
            departamentoDAO.save(departamento);
            JOptionPane.showMessageDialog(null, "Departamento Adicionado!!");
        }else{
            JOptionPane.showMessageDialog(null, "Departamento Já existe");
            return;
        }
    }
    public void UpdateDep(){
        String id;
        String nome = JOptionPane.showInputDialog("Digite o Nome do Departamento");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do Departamento"));

        Query<Departamento> query = MorphiaUtil.getDatastore().createQuery(Departamento.class).field("nome").contains(nome).field("numero").equal(numero);

        departamento =  query.get();

        boolean a = (departamento != null);
        JOptionPane.showMessageDialog(null, a ?  departamento:"Nenhum Departamento encontrado");

        if(a) {
            UpdateOperations<Departamento> updates = MorphiaUtil.getDatastore().createUpdateOperations(Departamento.class)
                    .set(JOptionPane.showInputDialog("Campo a ser atualizado"), JOptionPane.showInputDialog("Preencha"));
            MorphiaUtil.getDatastore().update(query, updates);
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar!!");
            return;
        }
    }
    public  void DeleteDep(){
        String nome = JOptionPane.showInputDialog("Digite o Nome do Departamento");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do Departamento"));

        departamento = MorphiaUtil.getDatastore().createQuery(Departamento.class).field("nome")
                .contains(nome)
                .field("numero")
                .equal(numero)
                .get();
        if (departamento != null) {
            Query<Departamento> query = MorphiaUtil.getDatastore().createQuery(Departamento.class)
                    .field("nome").contains(departamento.getNome()).field("numero").equal(departamento.getNumero());

            MorphiaUtil.getDatastore().delete(query);
            JOptionPane.showMessageDialog(null,  "Apagado com sucesso");

        }else{
            JOptionPane.showMessageDialog(null, "Erro Departamento não existe!!");
        }

        }
    public void FindAll(){
        List<Departamento> deps= departamentoDAO.findAll();
        StringBuilder listagem = new StringBuilder();
        for(Departamento d: deps) {
            listagem.append(d).append("\n");
        }
        JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Vazio" : listagem);
    }
}